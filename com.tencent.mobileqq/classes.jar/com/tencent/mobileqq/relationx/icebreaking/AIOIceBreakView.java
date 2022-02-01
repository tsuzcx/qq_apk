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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AIOIceBreakView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AIOIceBreakView.1(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AIOIceBreakView.OnIceImageClickListener jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakView$OnIceImageClickListener;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private int jdField_b_of_type_Int = 0;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new AIOIceBreakView.2(this);
  private CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView;
  private CustomImgView c;
  
  public AIOIceBreakView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public AIOIceBreakView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramIStickerRecEmoticon.a();
    paramIStickerRecEmoticon = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    paramIStickerRecEmoticon.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramIStickerRecEmoticon.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramIStickerRecEmoticon.mPlayGifImage = true;
    return paramIStickerRecEmoticon;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558656, this);
    ((TextView)localView.findViewById(2131380834)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368852));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)localView.findViewById(2131369012));
    this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)localView.findViewById(2131369013));
    this.c = ((CustomImgView)localView.findViewById(2131369016));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838410);
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 6.0F));
  }
  
  private void a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "sendPic");
    }
    if (paramIStickerRecEmoticon == null) {}
    do
    {
      return;
      paramIStickerRecEmoticon = (StickerRecData)paramIStickerRecEmoticon;
      StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramIStickerRecEmoticon.f());
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramIStickerRecEmoticon.m());
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("quick_send_original_md5", paramIStickerRecEmoticon.c());
      localIntent.putExtra("quick_send_original_size", paramIStickerRecEmoticon.b());
      localIntent.putExtra("quick_send_thumb_md5", paramIStickerRecEmoticon.g());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
      localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
      ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, null), 8, null, false);
      paramIStickerRecEmoticon = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramIStickerRecEmoticon == null);
    paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
  }
  
  private void a(CustomImgView paramCustomImgView, IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    paramCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130845178));
    if (paramIStickerRecEmoticon == null)
    {
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    Object localObject = paramIStickerRecEmoticon.a();
    if (localObject == null)
    {
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localObject = paramIStickerRecEmoticon.a((URL)localObject, a(paramIStickerRecEmoticon));
    if ((paramIStickerRecEmoticon instanceof StickerRecData)) {
      paramCustomImgView.setContentDescription(((StickerRecData)paramIStickerRecEmoticon).f());
    }
    paramCustomImgView.setTag(paramIStickerRecEmoticon);
    paramCustomImgView.setImageDrawable((Drawable)localObject);
    paramCustomImgView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<IStickerRecEmoticon> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 3)) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, (IStickerRecEmoticon)paramList.get(0));
    a(this.jdField_b_of_type_ComTencentWidgetCustomImgView, (IStickerRecEmoticon)paramList.get(1));
    a(this.c, (IStickerRecEmoticon)paramList.get(2));
    int i;
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1044)
    {
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        i = 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A4CA", "0X800A4CA", i, 0, "", "", "", "");
      }
    }
    else {
      if (paramInt < 3) {
        break label220;
      }
    }
    label220:
    for (paramList = "2";; paramList = "1")
    {
      paramInt = IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800B576", "0X800B576", paramInt, 0, paramList, "", "", "");
      return;
      i = 2;
      break;
    }
  }
  
  public void setOnIceImageClickListener(AIOIceBreakView.OnIceImageClickListener paramOnIceImageClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakView$OnIceImageClickListener = paramOnIceImageClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView
 * JD-Core Version:    0.7.0.1
 */