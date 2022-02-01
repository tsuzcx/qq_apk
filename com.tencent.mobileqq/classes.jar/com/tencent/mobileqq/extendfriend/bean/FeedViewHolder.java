package com.tencent.mobileqq.extendfriend.bean;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendLabelListAdapter;
import com.tencent.mobileqq.extendfriend.fragment.SquareItemClickListener;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FeedViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public ETTextView a;
  private FaceFetch jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFaceFetch;
  private ExtendFriendLabelListAdapter jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter;
  private SquareItemClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener;
  public ExtendFriendFeedView a;
  private ExtendFriendLabelFlowLayout jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout;
  public ExtendFriendVoiceView a;
  private VasRes jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  public ImageView b;
  public TextView b;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  public ImageView c;
  private int d;
  public ImageView d;
  private int e;
  public ImageView e;
  public ImageView f;
  
  public FeedViewHolder(View paramView, SquareItemClickListener paramSquareItemClickListener, FaceFetch paramFaceFetch, Activity paramActivity)
  {
    super(paramView);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFaceFetch = paramFaceFetch;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener = paramSquareItemClickListener;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366492);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368934));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380776));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369572));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380580));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370662));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364043));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363917));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131367072));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131380756));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368986));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364114));
    this.f = ((ImageView)paramView.findViewById(2131381702));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(ProfileGuideDialogUtils.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a(true);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_AndroidViewView.setBackground(null);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 10000)
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable)) {
        ((VasResDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).b(paramInt);
      }
    }
    else
    {
      return;
    }
    VasResDrawable localVasResDrawable = new VasResDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt);
    SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130846437);
    localSignatureAdapter.a(true);
    localSignatureAdapter.a(new FeedViewHolder.1(this));
    localVasResDrawable.a(localSignatureAdapter);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localVasResDrawable);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      SignatureFontAdapter localSignatureFontAdapter = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localSignatureFontAdapter.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a(localSignatureFontAdapter);
      localSignatureFontAdapter.a(-1);
      return;
    }
    ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(paramInt1, paramInt2);
  }
  
  public void a(FeedViewHolder paramFeedViewHolder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    int i;
    if (paramStrangerInfo.mIsMyFeed)
    {
      paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramFeedViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramStrangerInfo.mbAllowStrangerVote) {
        paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramStrangerInfo.mVoiceUrl)) {
        break label601;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramFeedViewHolder.getPosition();
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramStrangerInfo.mVoiceUrl, paramInt);
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramStrangerInfo.mVoiceUrl);
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramStrangerInfo.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFaceFetch.a(paramStrangerInfo.mUin, paramStrangerInfo.mNickName, paramFeedViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      paramFeedViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramFeedViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStrangerInfo.mNickName);
      paramFeedViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramStrangerInfo.mDeclaration), 3, 24));
      paramFeedViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramStrangerInfo.mLiked) {
        break label614;
      }
      if (paramStrangerInfo.mAvailLikeCount != 0) {
        break label607;
      }
      paramInt = 2130845254;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramStrangerInfo, paramFeedViewHolder.f);
      paramFeedViewHolder.f.setTag(paramStrangerInfo);
      a();
      if (!SimpleUIUtil.a())
      {
        a(paramStrangerInfo.clothesId);
        a(paramStrangerInfo.fontId, paramStrangerInfo.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = ExtendFriendLabelUtils.a(paramStrangerInfo, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = ExtendFriendLabelUtils.b(paramStrangerInfo, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = ExtendFriendLabelUtils.a(paramStrangerInfo, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label638;
      }
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter == null) {
        break label621;
      }
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter.a();
      label387:
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter.a(this.jdField_b_of_type_Boolean);
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter.a((List)localObject1);
      label407:
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter);
      if ((paramStrangerInfo.mSchoolInfos == null) || (paramStrangerInfo.mSchoolInfos.size() <= 0)) {
        break label675;
      }
      localObject1 = (StrangerInfo.SchoolInfo)paramStrangerInfo.mSchoolInfos.get(0);
      if (localObject1 == null) {
        break label663;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(((StrangerInfo.SchoolInfo)localObject1).b)) {
        paramFeedViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StrangerInfo.SchoolInfo)localObject1).b);
      }
      if (((StrangerInfo.SchoolInfo)localObject1).a != 2L) {
        break label650;
      }
      paramFeedViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845301);
      label510:
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label687;
      }
    }
    label650:
    label663:
    label675:
    label687:
    for (paramFeedViewHolder = "2";; paramFeedViewHolder = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", paramFeedViewHolder);
      paramFeedViewHolder = new HashMap();
      paramFeedViewHolder.put("feed_uid", paramStrangerInfo.mUin);
      ExpandReportUtils.a("expose#voice_tab#feed", true, -1L, -1L, paramFeedViewHolder, true, true);
      return;
      paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramFeedViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label601:
      i = 0;
      break label61;
      label607:
      paramInt = 2130845253;
      break label212;
      label614:
      paramInt = 2130845250;
      break label212;
      label621:
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendLabelListAdapter = new ExtendFriendLabelListAdapter(BaseApplicationImpl.getContext());
      break label387;
      label638:
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      break label407;
      paramFeedViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845302);
      break label510;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label510;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label510;
    }
  }
  
  public void a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if (paramSignatureTemplateInfo == null) {}
    do
    {
      return;
      if ((paramSignatureTemplateInfo.e != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.e)))
      {
        this.jdField_a_of_type_Int = Color.parseColor(paramSignatureTemplateInfo.e);
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
        }
      }
    } while ((paramSignatureTemplateInfo.t == null) || (TextUtils.isEmpty(paramSignatureTemplateInfo.t)));
    this.jdField_b_of_type_Int = Color.parseColor(paramSignatureTemplateInfo.t);
    if (SignTextEditFragment.a(this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_e_of_type_AndroidWidgetImageView.setColorFilter(null);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setColorFilter(-1291845633);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131364043) || (l - this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.a() >= 500L)) {
        break label46;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label46:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.a(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363917: 
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.c(i);
        break;
      case 2131366492: 
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.a(i, 2);
        break;
      case 2131368934: 
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.a(i, 1);
        break;
      case 2131381751: 
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.a(i);
        break;
      case 2131364043: 
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.b(i);
        break;
      case 2131364114: 
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.d(i);
        break;
      case 2131381702: 
        VipUtils.a(paramView, (StrangerInfo)paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.FeedViewHolder
 * JD-Core Version:    0.7.0.1
 */