package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressUtil;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisher;
import com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectVideoPresenter
{
  private Activity a;
  private PageLoadManager b = new PageLoadManager();
  private ISelectVideoView c;
  private AlbumUtils.LocalMediaInfo d;
  private URLDrawable e;
  private SelectVideoUIDelegate f = new SelectVideoUIDelegate();
  private ConditionChecker g = new ConditionChecker();
  
  public SelectVideoPresenter(Activity paramActivity, ISelectVideoView paramISelectVideoView)
  {
    this.a = paramActivity;
    this.c = paramISelectVideoView;
    h();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    if (paramBitmap.getHeight() > i) {
      return ImageUtil.c(paramBitmap, 0.5625F);
    }
    return ImageUtil.c(paramBitmap, 1.333333F);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject3 = new JSONObject();
    KanDianPublisher localKanDianPublisher = KanDianPublisher.INSTANCE;
    Object localObject4 = localObject3;
    if (paramIntent != null)
    {
      localObject4 = paramIntent.getStringExtra("extra");
      Object localObject1 = localObject3;
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        try
        {
          localObject1 = new JSONObject((String)localObject4);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("RIJUGC.SelectVideoPresenter", 1, localJSONException.getMessage());
          localObject2 = localObject3;
        }
      }
      int i = paramIntent.getIntExtra("key_from", 0);
      localObject3 = paramIntent.getStringExtra("arg_callback");
      localObject4 = this.d;
      if ((localObject4 != null) && (((AlbumUtils.LocalMediaInfo)localObject4).e != null)) {
        localKanDianPublisher.buildSelectVideoInfo(localObject2, this.d.j, this.d.f, this.d.k, this.d.a(), this.d.b(), this.d.e);
      }
      localKanDianPublisher.buildPublisherScene(localObject2, i, (String)localObject3);
      localObject3 = (CommunityInfo)paramIntent.getParcelableExtra("key_kd_community_info");
      if (localObject3 != null) {
        localKanDianPublisher.buildKDCommunityInfo(localObject2, ((CommunityInfo)localObject3).getCommunityId(), ((CommunityInfo)localObject3).getTitle());
      }
      paramIntent = (UgcEntryExtraInfo)paramIntent.getParcelableExtra("key_ugc_entry_extra_info");
      localObject4 = localObject2;
      if (paramIntent != null)
      {
        localKanDianPublisher.buildUgcEntryExtraInfo(localObject2, paramIntent);
        localObject4 = localObject2;
      }
    }
    localKanDianPublisher.openPublishArticlePageForResult(this.a, 10001, (JSONObject)localObject4);
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new SavePicTask(paramBitmap, paramString);
    paramBitmap.a(new SelectVideoPresenter.8(this));
    paramBitmap.a();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ugType", "3");
    if (paramBoolean2) {
      localHashMap.put("stateType", "2");
    } else {
      localHashMap.put("stateType", "1");
    }
    String str;
    if (paramBoolean1) {
      str = "actKanDianUgExpo";
    } else {
      str = "actKanDianUgClick";
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(RIJQQAppInterfaceUtil.d(), str, true, 0L, 0L, localHashMap, null);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.01F;
  }
  
  private boolean a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    boolean bool = true;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    float f1 = i / j;
    if (j > i ? !a(f1, 0.5625F) : !a(f1, 1.333333F)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isCoverSuitable, result=");
      paramString.append(bool);
      paramString.append(", width=");
      paramString.append(i);
      paramString.append(",height=");
      paramString.append(j);
      paramString.append(", ratio=");
      paramString.append(f1);
      QLog.i("RIJUGC.SelectVideoPresenter", 2, paramString.toString());
    }
    return bool;
  }
  
  private void h()
  {
    this.g.a("暂不支持该类视频格式", new SelectVideoPresenter.1(this));
    this.g.a("视频时长短于5秒，无法上传", new SelectVideoPresenter.2(this));
    this.g.a("视频文件不存在", new SelectVideoPresenter.3(this));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("视频大小超过");
    ((StringBuilder)localObject).append(VideoCompressUtil.b());
    ((StringBuilder)localObject).append("，无法上传");
    localObject = ((StringBuilder)localObject).toString();
    this.g.a(localObject, new SelectVideoPresenter.4(this));
    this.b.a(new SelectVideoPresenter.5(this));
  }
  
  private void i()
  {
    URL localURL = AlbumUtil.generateAlbumVideoThumbURL(this.d.e, null);
    this.d.k = AbsDownloader.getFilePath(localURL.toString());
    if ((new File(this.d.k).exists()) && (a(this.d.k)))
    {
      k();
      return;
    }
    this.e = URLDrawable.getDrawable(localURL, null);
    if (this.e.getStatus() == 1)
    {
      a(a(ImageUtil.b(this.e.getCurrDrawable())), this.d.k);
      return;
    }
    this.e.setURLDrawableListener(new SelectVideoPresenter.7(this));
    this.e.startDownload();
  }
  
  private void j()
  {
    AlbumUtils.LocalMediaInfo localLocalMediaInfo = this.d;
    int j = 0;
    int i;
    if (localLocalMediaInfo == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = j;
      while (i < this.c.a())
      {
        localLocalMediaInfo = this.c.c(i);
        if (this.g.a(localLocalMediaInfo, null))
        {
          this.c.b(i);
          return;
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.SelectVideoPresenter", 2, "not found the select video...");
      }
      QQToast.makeText(this.a, 2131892165, 1).show();
    }
  }
  
  private void k()
  {
    a(this.a.getIntent());
  }
  
  private void l()
  {
    QQToast.makeText(this.a, "请选择一个视频", 0).show();
  }
  
  public SelectVideoUIDelegate a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    this.d = paramLocalMediaInfo;
    this.f.a(paramLocalMediaInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      RIJJumpUtils.c(this.a, "kandianapi://readinjoy/open?src_type=external&target=16");
    } else {
      RIJJumpUtils.c(this.a, Aladdin.getConfig(515).getString("jump_url", ""));
    }
    c(paramBoolean);
  }
  
  public void b()
  {
    this.b.a();
  }
  
  public void b(boolean paramBoolean)
  {
    a(true, paramBoolean);
  }
  
  public boolean b(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return this.g.a(paramLocalMediaInfo, new SelectVideoPresenter.6(this));
  }
  
  public Boolean c()
  {
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, true);
    long l1 = ((SharedPreferences)localObject).getLong("show_lead_to_kan_dian_dialog_time", 0L);
    long l2 = System.currentTimeMillis();
    Boolean localBoolean = Boolean.valueOf(false);
    if (l2 - l1 < 86400000L) {
      return localBoolean;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(515);
    if (localAladdinConfig == null) {
      return localBoolean;
    }
    if ((localAladdinConfig.getIntegerFromString("show_dialog", 0) == 1) && (!TextUtils.isEmpty(localAladdinConfig.getString("jump_url", ""))))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("show_lead_to_kan_dian_dialog_time", l2);
      ((SharedPreferences.Editor)localObject).commit();
      return Boolean.valueOf(true);
    }
    return localBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    a(false, paramBoolean);
  }
  
  public String d()
  {
    return Aladdin.getConfig(515).getString("title", "");
  }
  
  public String e()
  {
    return Aladdin.getConfig(515).getString("content", "");
  }
  
  public boolean f()
  {
    return PackageUtil.a(this.a, "com.tencent.rijvideo");
  }
  
  public void g()
  {
    if (this.d == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter
 * JD-Core Version:    0.7.0.1
 */