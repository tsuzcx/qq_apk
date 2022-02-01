package com.tencent.mobileqq.relationx.icebreaking;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloIceBreakShow;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.bean.IceBreakCmShowData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.CustomImgView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AIOIceBreakView
  extends LinearLayout
{
  private Context a;
  private QQAppInterface b;
  private BaseActivity c;
  private BaseChatPie d;
  private int e;
  private Drawable f;
  private CustomImgView g;
  private CustomImgView h;
  private CustomImgView i;
  private RelativeLayout j;
  private RelativeLayout k;
  private AIOIceBreakView.OnIceImageClickListener l;
  private int m = 0;
  private IApolloIceBreakShow n;
  private boolean o = true;
  private View.OnClickListener p = new AIOIceBreakView.1(this);
  private View.OnClickListener q = new AIOIceBreakView.2(this);
  
  public AIOIceBreakView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public AIOIceBreakView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    Object localObject = paramIStickerRecEmoticon.c();
    paramIStickerRecEmoticon = (IStickerRecEmoticon)localObject;
    if (localObject == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    localObject = this.f;
    paramIStickerRecEmoticon.mLoadingDrawable = ((Drawable)localObject);
    paramIStickerRecEmoticon.mFailedDrawable = ((Drawable)localObject);
    paramIStickerRecEmoticon.mPlayGifImage = true;
    return paramIStickerRecEmoticon;
  }
  
  private IceBreakCmShowData a(List<IStickerRecEmoticon> paramList)
  {
    if (paramList.size() >= 4)
    {
      paramList = (IStickerRecEmoticon)paramList.get(3);
      if ((paramList instanceof IceBreakCmShowData))
      {
        paramList = (IceBreakCmShowData)paramList;
        break label38;
      }
    }
    paramList = null;
    label38:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCmShowTemplate result = ");
      localStringBuilder.append(paramList);
      QLog.d("AIOIceBreakView", 2, localStringBuilder.toString());
    }
    return paramList;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakView", 2, "sendCmShowEmotion");
    }
    this.n.onSend(this.b, this.d.bv());
  }
  
  private void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(IceBreakCmShowData paramIceBreakCmShowData)
  {
    View localView = this.n.getView();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAndPlayCmShow cmShowView = ");
      localStringBuilder.append(localView);
      localStringBuilder.append(",iceBreakCmShowData = ");
      localStringBuilder.append(paramIceBreakCmShowData);
      QLog.d("AIOIceBreakView", 2, localStringBuilder.toString());
    }
    if (localView == null)
    {
      QLog.e("AIOIceBreakView", 1, "invalid cmShowView.");
      return;
    }
    if (paramIceBreakCmShowData == null)
    {
      QLog.e("AIOIceBreakView", 1, "invalid iceBreakCmShowData.");
      return;
    }
    if (localView.getParent() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOIceBreakView", 2, "updateAndPlayCmShow cmShowView not added");
      }
      return;
    }
    localView.setOnClickListener(this.q);
    localView.setTag(paramIceBreakCmShowData);
    paramIceBreakCmShowData = paramIceBreakCmShowData.n();
    this.n.setJson(paramIceBreakCmShowData, this.d.ah);
    if (this.n.isReady()) {
      this.n.play();
    }
  }
  
  private void a(CustomImgView paramCustomImgView, IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    paramCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130846492));
    if (paramIStickerRecEmoticon == null)
    {
      paramCustomImgView.setImageDrawable(this.f);
      return;
    }
    Object localObject = paramIStickerRecEmoticon.k();
    if (localObject == null)
    {
      paramCustomImgView.setImageDrawable(this.f);
      return;
    }
    localObject = paramIStickerRecEmoticon.a((URL)localObject, a(paramIStickerRecEmoticon));
    if ((paramIStickerRecEmoticon instanceof StickerRecData)) {
      paramCustomImgView.setContentDescription(((StickerRecData)paramIStickerRecEmoticon).o());
    }
    paramCustomImgView.setTag(paramIStickerRecEmoticon);
    paramCustomImgView.setImageDrawable((Drawable)localObject);
    paramCustomImgView.setOnClickListener(this.q);
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(this.a).inflate(2131624110, this);
    ((TextView)localView.findViewById(2131449011)).setOnClickListener(this.p);
    this.k = ((RelativeLayout)localView.findViewById(2131449010));
    this.j = ((RelativeLayout)localView.findViewById(2131435488));
    this.g = ((CustomImgView)localView.findViewById(2131435647));
    this.h = ((CustomImgView)localView.findViewById(2131435648));
    this.i = ((CustomImgView)localView.findViewById(2131435651));
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    this.h.setScaleType(ImageView.ScaleType.FIT_XY);
    this.i.setScaleType(ImageView.ScaleType.FIT_XY);
    this.f = getResources().getDrawable(2130838305);
    this.e = ((int)(getResources().getDisplayMetrics().density * 6.0F));
    this.n = ((IApolloIceBreakShow)QRoute.api(IApolloIceBreakShow.class));
  }
  
  private void b(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "sendPic");
    }
    if (paramIStickerRecEmoticon == null) {
      return;
    }
    paramIStickerRecEmoticon = (StickerRecData)paramIStickerRecEmoticon;
    ((IStickerRecManager)this.b.getRuntimeService(IStickerRecManager.class)).setCurrentText(paramIStickerRecEmoticon.o());
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramIStickerRecEmoticon.B());
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("uin", this.d.ah.b);
    localIntent.putExtra("uintype", this.d.ah.a);
    localIntent.putExtra("troop_uin", this.d.ah.c);
    localIntent.putExtra("key_confess_topicid", this.d.ah.v);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("send_in_background", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("quick_send_original_md5", paramIStickerRecEmoticon.l());
    localIntent.putExtra("quick_send_original_size", paramIStickerRecEmoticon.q());
    localIntent.putExtra("quick_send_thumb_md5", paramIStickerRecEmoticon.p());
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
    ThreadManager.post(new SendPhotoTask(this.c, localIntent, null), 8, null, false);
    paramIStickerRecEmoticon = this.b.getHandler(ChatActivity.class);
    if (paramIStickerRecEmoticon != null) {
      paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
    }
  }
  
  private void c()
  {
    int i1 = ViewUtils.dip2px(64.0F);
    this.n.init(getContext(), i1, i1, this.b);
    View localView = this.n.getView();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addCmshowView2Panel cmShowView = ");
      ((StringBuilder)localObject).append(localView);
      QLog.d("AIOIceBreakView", 2, ((StringBuilder)localObject).toString());
    }
    if (localView == null)
    {
      QLog.e("AIOIceBreakView", 1, "invalid cmShowView.");
      return;
    }
    if (localView.getParent() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOIceBreakView", 2, "addCmshowView2Panel cmShowView has added");
      }
      return;
    }
    Object localObject = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131435651);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(16.0F);
    this.j.addView(localView, (ViewGroup.LayoutParams)localObject);
    a(this.g, i1);
    a(this.h, i1);
    a(this.i, i1);
  }
  
  public void a(View paramView, String paramString, StickerRecData paramStickerRecData)
  {
    VideoReport.setPageId(this.d.aW(), "pg_gb_aio");
    HashMap localHashMap = new HashMap(1);
    if (paramStickerRecData.x() != null) {
      localHashMap.put("sticker_id", paramStickerRecData.x());
    }
    VideoReport.setElementId(paramView, "em_gb_ice_sticker");
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementParams(paramView, localHashMap);
    paramView.post(new AIOIceBreakView.3(this, paramString, paramView, localHashMap));
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<IStickerRecEmoticon> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() < 3) {
        return;
      }
      this.m = paramInt;
      this.b = paramBaseChatPie.d;
      this.d = paramBaseChatPie;
      this.c = paramBaseChatPie.aX();
      Object localObject = this.d;
      if (((localObject instanceof LimitChatPie)) || ((localObject instanceof GameMsgChatPie))) {
        this.k.setVisibility(8);
      }
      localObject = this.g;
      boolean bool = false;
      a((CustomImgView)localObject, (IStickerRecEmoticon)paramList.get(0));
      a(this.h, (IStickerRecEmoticon)paramList.get(1));
      a(this.i, (IStickerRecEmoticon)paramList.get(2));
      if (paramBaseChatPie.ah.a != 1044)
      {
        int i1;
        if (paramBaseChatPie.ah.a == 0) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(this.b, "CliOper", "", "", "0X800A4CA", "0X800A4CA", i1, 0, "", "", "", "");
      }
      if ((((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).isCmShowMemeEnabledForIceBreak()) && (this.o))
      {
        paramList = a(paramList);
        if (paramList != null) {
          bool = true;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindData cmShowDataExist = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("AIOIceBreakView", 2, ((StringBuilder)localObject).toString());
        }
        if (bool)
        {
          c();
          a(paramList);
          IceBreakingUtil.a(paramBaseChatPie, paramList.n());
          IceBreakingUtil.a(IceBreakingUtil.Event.EMOJI_EXPO);
        }
        else
        {
          QLog.d("AIOIceBreakView", 1, "icebreak cmShowData invalid.");
        }
      }
      if (paramInt >= 3) {
        paramList = "2";
      } else {
        paramList = "1";
      }
      paramInt = IceBreakingUtil.a(this.b, paramBaseChatPie.ah);
      ReportController.b(this.b, "CliOper", "", "", "0X800B576", "0X800B576", paramInt, 0, paramList, "", "", "");
    }
  }
  
  public void setOnIceImageClickListener(AIOIceBreakView.OnIceImageClickListener paramOnIceImageClickListener)
  {
    this.l = paramOnIceImageClickListener;
  }
  
  public void setShowCmShow(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView
 * JD-Core Version:    0.7.0.1
 */