package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import mqq.os.MqqHandler;

public class SearchEmoticonFragment
  extends AIOEmotionBaseFragment
  implements View.OnClickListener
{
  public static String d = "forward_search_emoticon";
  GalleryProgressView e;
  TextView f;
  ImageView g;
  Button h;
  Button i;
  TextView j;
  View k;
  ImageView l;
  private Drawable m;
  private int n;
  private float o;
  private Activity p = null;
  private SearchEmoticonWebBean q;
  
  public static Intent a(MessageForPic paramMessageForPic, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 1);
    paramQQAppInterface.putInt("forward_source_uin_type", paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    localIntent.putExtra(d, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPic.frienduin);
    localStringBuilder.append(paramMessageForPic.uniseq);
    localStringBuilder.append(paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_task_key", localStringBuilder.toString());
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    localIntent.putExtras(paramQQAppInterface);
    if ((!ActionMsgUtil.a(paramMessageForPic.msgtype)) && (paramMessageForPic.msgtype != -3001) && (paramMessageForPic.msgtype != -30002) && (paramMessageForPic.msgtype != -30003)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt == 0) {
      paramInt = 65537;
    } else {
      paramInt = 1;
    }
    paramQQAppInterface = URLDrawableHelper.getURL(paramMessageForPic, paramInt);
    localIntent.putExtra("forward_urldrawable", true);
    localIntent.putExtra("forward_urldrawable_thumb_url", paramQQAppInterface.toString());
    localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
    paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
    localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
    if (new File(paramMessageForPic.path).exists())
    {
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
    }
    else
    {
      paramQQAppInterface = null;
      paramContext = paramContext.getURL().toString();
      if (AbsDownloader.hasFile(paramContext))
      {
        paramContext = AbsDownloader.getFile(paramContext);
        paramMessageForPic = paramQQAppInterface;
        if (paramContext != null) {
          paramMessageForPic = paramContext.getAbsolutePath();
        }
      }
      else
      {
        paramContext = AbsDownloader.getFile(URLDrawableHelper.getURL(paramMessageForPic, 65537).toString());
        paramMessageForPic = paramQQAppInterface;
        if (paramContext != null)
        {
          paramMessageForPic = paramQQAppInterface;
          if (paramContext.exists()) {
            paramMessageForPic = paramContext.getAbsolutePath();
          }
        }
      }
      localIntent.putExtra("forward_extra", paramMessageForPic);
    }
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_is_tab_search_emo", true);
    return localIntent;
  }
  
  public static void a(Context paramContext, SearchEmoticonWebBean paramSearchEmoticonWebBean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("SearchEmoticonWebBean", paramSearchEmoticonWebBean);
    PublicFragmentActivity.a(paramContext, localIntent, SearchEmoticonFragment.class);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    ThreadManager.getFileThreadHandler().post(new SearchEmoticonFragment.2(this, paramMessageForPic));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131629663, paramViewGroup, false);
  }
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public boolean a()
  {
    return false;
  }
  
  protected void b() {}
  
  protected void b(View paramView)
  {
    this.f = ((TextView)paramView.findViewById(2131427959));
    this.j = ((TextView)paramView.findViewById(2131431780));
    this.k = paramView.findViewById(2131432471);
    this.l = ((ImageView)paramView.findViewById(2131431779));
    this.g = ((ImageView)paramView.findViewById(2131427956));
    ImageView localImageView = (ImageView)paramView.findViewById(2131427950);
    this.e = new GalleryProgressView();
    this.e.a(super.getBaseActivity(), localImageView);
    this.m = getResources().getDrawable(2130838305);
    this.o = getResources().getDisplayMetrics().density;
    this.n = ((int)(this.o * 6.0F));
    this.h = ((Button)paramView.findViewById(2131445613));
    this.i = ((Button)paramView.findViewById(2131427823));
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.q = ((SearchEmoticonWebBean)this.p.getIntent().getParcelableExtra("SearchEmoticonWebBean"));
    if (this.q == null)
    {
      this.q = new SearchEmoticonWebBean();
      this.q.g = 0;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    paramBundle = this.m;
    localURLDrawableOptions.mLoadingDrawable = paramBundle;
    localURLDrawableOptions.mFailedDrawable = paramBundle;
    localURLDrawableOptions.mGifRoundCorner = this.n;
    localURLDrawableOptions.mPlayGifImage = true;
    paramBundle = URLDrawable.getDrawable(this.q.b, localURLDrawableOptions);
    this.g.setImageDrawable(paramBundle);
    SearchEmoticonWebBean localSearchEmoticonWebBean = this.q;
    localSearchEmoticonWebBean.m = AbsDownloader.getFilePath(localSearchEmoticonWebBean.b);
    if (this.q.g != 0)
    {
      this.k.setVisibility(0);
      this.k.setClickable(true);
      this.k.setOnTouchListener(new SearchEmoticonFragment.1(this));
      if (!TextUtils.isEmpty(this.q.h)) {
        paramBundle = URLDrawable.getDrawable(this.q.h, localURLDrawableOptions);
      }
      if (this.q.g == 1)
      {
        this.l.setImageDrawable(paramBundle);
        this.j.setText(this.q.j);
        return;
      }
      if (this.q.g == 2)
      {
        this.l.setVisibility(8);
        this.j.setText(this.q.l);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.b.getString(2131917002));
      paramIntent = new Bundle(paramIntent.getExtras());
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.c() != null) {
        ForwardUtils.a(super.c(), super.getBaseActivity(), this.b, localIntent, ThreadManager.getUIHandler());
      }
      ReportController.b(null, "dc00898", "", "", "0X8009EAC", "0X8009EAC", 0, 0, "", "", "", "");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.p = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = c();
    if (localObject == null)
    {
      QLog.d("SearchEmoticonFragment", 1, "error runtime");
    }
    else if (!FileUtils.fileExists(this.q.m))
    {
      QQToast.makeText(this.p, 1, HardCodeUtil.a(2131911092), 0).show();
    }
    else
    {
      MessageForPic localMessageForPic = (MessageForPic)MessageRecordFactory.a(-2000);
      localMessageForPic.path = this.q.m;
      localMessageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(this.q.m));
      localMessageForPic.thumbMsgUrl = this.q.b;
      localMessageForPic.bigMsgUrl = this.q.b;
      localMessageForPic.imageType = 2000;
      int i1 = paramView.getId();
      if (i1 != 2131427823)
      {
        if (i1 == 2131445613)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SearchEmoticonFragment", 2, "发送给好友");
          }
          localObject = a(localMessageForPic, 0, (QQAppInterface)localObject, this.b);
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
          ForwardBaseOption.a(super.getBaseActivity(), (Intent)localObject, 1);
          a(localMessageForPic);
          ReportController.b(null, "dc00898", "", "", "0X8009EAA", "0X8009EAA", 0, 0, "", "", "", "");
        }
      }
      else
      {
        URLDrawable localURLDrawable = (URLDrawable)this.g.getDrawable();
        localURLDrawable.setTag(localMessageForPic);
        AIOGalleryUtils.a(this.b, (QQAppInterface)localObject, localURLDrawable, localMessageForPic.frienduin, getBaseActivity().getResources().getDimensionPixelSize(2131299920), null, localMessageForPic.picExtraData);
        ReportController.b(null, "dc00898", "", "", "0X8009EAD", "0X8009EAD", 0, 0, "", "", "", "");
        EmoticonOperateReport.reportFavAddEmotionEvent((AppInterface)localObject, 5, localMessageForPic.md5, null);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onStart()
  {
    super.onStart();
    ReportController.b(null, "dc00898", "", "", "0X8009EA9", "0X8009EA9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment
 * JD-Core Version:    0.7.0.1
 */