package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendObserver;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFullPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlay;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.view.VideoCountDownView;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFullPlayController
  implements Handler.Callback, View.OnClickListener, IVideoFullPlayController
{
  private Context a;
  private IVideoPlay b;
  private VideoFullPlayController.OnFullPlayListener c;
  private VideoFullPlayController.RecommendDataAdapter d;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  private boolean h = true;
  private Handler i;
  private int j;
  private FrameLayout k;
  private VideoCountDownView l;
  private BaseVideoPlayParam m;
  private BaseVideoPlayParam n;
  private BaseVideoPlayParam o;
  private String p;
  private int q;
  private boolean r;
  private VideoPlayRecommendHandler s;
  private VideoPlayRecommendObserver t;
  private Queue<BaseVideoPlayParam> u = new ArrayDeque();
  private int v;
  private List<VideoFullPlayController.FullPlayInfo> w;
  private int x;
  
  public VideoFullPlayController(Activity paramActivity, FrameLayout paramFrameLayout, VideoFullPlayController.RecommendDataAdapter paramRecommendDataAdapter)
  {
    this.a = paramActivity;
    this.k = paramFrameLayout;
    this.d = paramRecommendDataAdapter;
    this.i = new WeakReferenceHandler(this);
    this.w = new ArrayList();
    paramActivity = ReadInJoyUtils.b();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.s = ((VideoPlayRecommendHandler)paramActivity.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.t = new VideoFullPlayController.VideoRecommendObserver(this, null);
      this.p = paramActivity.getCurrentUin();
    }
  }
  
  private void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2)
  {
    if (((paramBaseVideoPlayParam1 instanceof VideoPlayParam)) && ((paramBaseVideoPlayParam2 instanceof VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = (VideoPlayParam)paramBaseVideoPlayParam1;
      paramBaseVideoPlayParam2 = (VideoPlayParam)paramBaseVideoPlayParam2;
      try
      {
        paramBaseVideoPlayParam2 = paramBaseVideoPlayParam2.D;
        if (paramBaseVideoPlayParam2 != null)
        {
          paramBaseVideoPlayParam2.mChannelID = paramBaseVideoPlayParam1.D.mChannelID;
          paramBaseVideoPlayParam2.mRecommendTime = paramBaseVideoPlayParam1.D.mRecommendTime;
          return;
        }
      }
      catch (Throwable paramBaseVideoPlayParam1)
      {
        if (QLog.isColorLevel())
        {
          paramBaseVideoPlayParam2 = new StringBuilder();
          paramBaseVideoPlayParam2.append("fixNextPlayVideoPlayParam error:");
          paramBaseVideoPlayParam2.append(paramBaseVideoPlayParam1.getMessage());
          QLog.e("VideoFullPlayController", 2, paramBaseVideoPlayParam2.toString());
        }
      }
    }
  }
  
  private void l()
  {
    if (this.s != null)
    {
      Object localObject = this.n;
      if (localObject != null)
      {
        localObject = ((BaseVideoPlayParam)localObject).b();
        this.s.a(this.t, Long.parseLong(this.p), (VideoInfo)localObject, 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null, 0);
      }
    }
  }
  
  private void m()
  {
    Context localContext = this.a;
    if ((localContext instanceof BaseActivity))
    {
      VideoPlayRecommendObserver localVideoPlayRecommendObserver = this.t;
      if (localVideoPlayRecommendObserver != null) {
        ((BaseActivity)localContext).removeObserver(localVideoPlayRecommendObserver);
      }
    }
  }
  
  private void n()
  {
    this.o.e = (this.n.e + 1);
    a(this.n, this.o);
  }
  
  private void o()
  {
    Object localObject = this.o;
    if ((localObject != null) && (this.b != null))
    {
      this.u.remove(localObject);
      localObject = this.c;
      if (localObject != null) {
        ((VideoFullPlayController.OnFullPlayListener)localObject).a(this.n, this.o, this.q, this.r);
      }
      this.b.a(this.o);
      this.x += 1;
    }
    this.o = null;
    this.r = false;
  }
  
  public String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
      {
        VideoFullPlayController.FullPlayInfo localFullPlayInfo = (VideoFullPlayController.FullPlayInfo)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localFullPlayInfo.a.a());
        localJSONObject2.put("playCount", localFullPlayInfo.b);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
      localJSONObject1.put("first_rowKey", paramString);
      paramString = localJSONObject1.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if (!this.g) {
      a(this.j);
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    if (!f()) {
      return;
    }
    if (this.j > 0)
    {
      this.l.a(paramInt);
      a(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.o != null)
    {
      e();
      o();
      return;
    }
    this.l.a();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.i.sendMessageDelayed(localMessage, 500L);
  }
  
  public void a(IVideoPlay paramIVideoPlay)
  {
    this.b = paramIVideoPlay;
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    this.f = true;
    this.g = (true ^ NetworkUtil.isWifiConnected(this.a));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterCountDownMode videoPlayParam:");
      ((StringBuilder)localObject).append(paramBaseVideoPlayParam);
      ((StringBuilder)localObject).append(" mVideoRootFrameLayout:");
      ((StringBuilder)localObject).append(this.k);
      QLog.i("VideoFullPlayController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if ((localObject instanceof BaseActivity))
    {
      VideoPlayRecommendObserver localVideoPlayRecommendObserver = this.t;
      if (localVideoPlayRecommendObserver != null) {
        ((BaseActivity)localObject).addObserver(localVideoPlayRecommendObserver);
      }
    }
    if ((paramBaseVideoPlayParam != null) && (this.k != null))
    {
      this.m = paramBaseVideoPlayParam;
      if (this.l == null)
      {
        this.l = new VideoCountDownView(this.a);
        this.l.setOnClickListener(null);
        this.l.setOnCustomClickListener(this);
      }
      this.l.c();
      this.l.setTitle(paramBaseVideoPlayParam.a);
      if (this.h) {
        this.l.a(new PublicAccountHttpDownloaderImpl().makeURL(paramBaseVideoPlayParam.b, 0));
      } else {
        this.l.b();
      }
      if (this.l.getParent() != null) {
        ((ViewGroup)this.l.getParent()).removeView(this.l);
      }
      this.k.addView(this.l);
      j();
      paramBaseVideoPlayParam = new VideoR5.Builder(null, null, paramBaseVideoPlayParam.d, paramBaseVideoPlayParam.a()).a((int)paramBaseVideoPlayParam.f).b().a();
      PublicAccountReportUtils.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.v), "", paramBaseVideoPlayParam, false);
    }
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterFullMode videoPlayParam:");
      localStringBuilder.append(paramBaseVideoPlayParam);
      QLog.i("VideoFullPlayController", 2, localStringBuilder.toString());
    }
    this.e = true;
    this.n = paramBaseVideoPlayParam;
    this.x = 1;
    this.q = paramInt;
    this.r = true;
    this.u.clear();
    if (this.n != null)
    {
      if (paramBaseVideoPlayParam.f == 409409L)
      {
        this.v = 0;
        return;
      }
      if (paramBaseVideoPlayParam.f == 56L)
      {
        this.v = 1;
        return;
      }
      this.v = 2;
    }
  }
  
  public void a(VideoFullPlayController.OnFullPlayListener paramOnFullPlayListener)
  {
    this.c = paramOnFullPlayListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public BaseVideoPlayParam b()
  {
    return this.n;
  }
  
  public void b(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFetch nextVideoPlayParam:");
      localStringBuilder.append(paramBaseVideoPlayParam);
      QLog.d("VideoFullPlayController", 2, localStringBuilder.toString());
    }
    this.o = paramBaseVideoPlayParam;
    this.l.setIsXgMode(this.g);
    this.l.setNextVideoInfo(paramBaseVideoPlayParam);
    if (!this.g) {
      a(3);
    }
    n();
  }
  
  public void c()
  {
    this.e = false;
    BaseVideoPlayParam localBaseVideoPlayParam = this.n;
    if (localBaseVideoPlayParam != null) {
      this.w.add(new VideoFullPlayController.FullPlayInfo(localBaseVideoPlayParam, this.x));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public void e()
  {
    this.f = false;
    this.k.removeView(this.l);
    m();
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public String g()
  {
    return String.valueOf(this.v);
  }
  
  public void h()
  {
    this.i.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l1 = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l1 >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l1 / 1000L));
        a(paramMessage.arg1);
        return true;
      }
      a(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    }
    return true;
  }
  
  public void i()
  {
    m();
    this.s = null;
  }
  
  public void j()
  {
    BaseVideoPlayParam localBaseVideoPlayParam = (BaseVideoPlayParam)this.u.peek();
    if (localBaseVideoPlayParam == null)
    {
      l();
      return;
    }
    b(localBaseVideoPlayParam);
  }
  
  public List<VideoFullPlayController.FullPlayInfo> k()
  {
    return this.w;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131433911: 
      paramView = this.c;
      if (paramView != null)
      {
        paramView.cV_();
        return;
      }
      break;
    case 2131429990: 
      e();
      paramView = this.b;
      if (paramView != null) {
        paramView.a(this.m);
      }
      paramView = this.m;
      if (paramView == null) {
        return;
      }
      paramView = new VideoR5.Builder(null, null, paramView.d, this.m.a()).a((int)this.m.f).b().a();
      PublicAccountReportUtils.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.v), "", paramView, false);
      return;
    case 2131429957: 
    case 2131448810: 
      paramView = this.o;
      if (paramView == null) {
        return;
      }
      paramView = new VideoR5.Builder(null, null, paramView.d, this.o.a()).a((int)this.o.f).k(this.o.a()).b().a();
      PublicAccountReportUtils.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.v), "", paramView, false);
      e();
      o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController
 * JD-Core Version:    0.7.0.1
 */