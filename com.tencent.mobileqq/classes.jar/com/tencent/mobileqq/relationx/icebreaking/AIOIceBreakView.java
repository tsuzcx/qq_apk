package com.tencent.mobileqq.relationx.icebreaking;

import aihq;
import aiig;
import aiin;
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
import bbdd;
import bbde;
import bbdf;
import bbdk;
import bdla;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbdd(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bbdf jdField_a_of_type_Bbdf;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bbde(this);
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
  private URLDrawable.URLDrawableOptions a(aihq paramaihq)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramaihq.a();
    paramaihq = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramaihq = URLDrawable.URLDrawableOptions.obtain();
    }
    paramaihq.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaihq.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaihq.mPlayGifImage = true;
    return paramaihq;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558632, this);
    ((TextView)localView.findViewById(2131380391)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368620));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)localView.findViewById(2131368780));
    this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)localView.findViewById(2131368781));
    this.c = ((CustomImgView)localView.findViewById(2131368784));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838341);
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 6.0F));
  }
  
  private void a(aihq paramaihq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "sendPic");
    }
    if (paramaihq == null) {}
    do
    {
      return;
      paramaihq = (aiig)paramaihq;
      aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramaihq.f());
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaihq.m());
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.troopUin);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.topicId);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("quick_send_original_md5", paramaihq.c());
      localIntent.putExtra("quick_send_original_size", paramaihq.b());
      localIntent.putExtra("quick_send_thumb_md5", paramaihq.g());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
      localIntent.putExtra("HOT_PIC_HAS_EXTRA", true);
      ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, null), 8, null, false);
      paramaihq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramaihq == null);
    paramaihq.sendMessage(paramaihq.obtainMessage(92));
  }
  
  private void a(CustomImgView paramCustomImgView, aihq paramaihq)
  {
    paramCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130845018));
    if (paramaihq == null)
    {
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    Object localObject = paramaihq.a();
    if (localObject == null)
    {
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    localObject = paramaihq.a((URL)localObject, a(paramaihq));
    if ((paramaihq instanceof aiig)) {
      paramCustomImgView.setContentDescription(((aiig)paramaihq).f());
    }
    paramCustomImgView.setTag(paramaihq);
    paramCustomImgView.setImageDrawable((Drawable)localObject);
    paramCustomImgView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<aihq> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 3)) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.getActivity();
    a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, (aihq)paramList.get(0));
    a(this.jdField_b_of_type_ComTencentWidgetCustomImgView, (aihq)paramList.get(1));
    a(this.c, (aihq)paramList.get(2));
    int i;
    if (paramBaseChatPie.sessionInfo.curType != 1044)
    {
      if (paramBaseChatPie.sessionInfo.curType == 0)
      {
        i = 1;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A4CA", "0X800A4CA", i, 0, "", "", "", "");
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
      paramInt = bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.sessionInfo);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800B576", "0X800B576", paramInt, 0, paramList, "", "", "");
      return;
      i = 2;
      break;
    }
  }
  
  public void setOnIceImageClickListener(bbdf parambbdf)
  {
    this.jdField_a_of_type_Bbdf = parambbdf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView
 * JD-Core Version:    0.7.0.1
 */