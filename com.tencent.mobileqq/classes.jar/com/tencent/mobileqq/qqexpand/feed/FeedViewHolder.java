package com.tencent.mobileqq.qqexpand.feed;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.SchoolInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public ETTextView a;
  private final QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendLabelListAdapter jdField_a_of_type_ComTencentMobileqqQqexpandFeedExtendFriendLabelListAdapter;
  private final FaceFetch jdField_a_of_type_ComTencentMobileqqQqexpandFeedFaceFetch;
  private final SquareItemClickListener jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener;
  public ExtendFriendFeedView a;
  private final ExtendFriendLabelFlowLayout jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendLabelFlowLayout;
  public ExpandVoiceView a;
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
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFaceFetch = paramFaceFetch;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener = paramSquareItemClickListener;
    paramSquareItemClickListener = (QBaseActivity)paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramSquareItemClickListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(1912930314);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(1912930329));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(1912930381));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(1912930331));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(1912930375));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(1912930336));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(1912930307));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(1912930306));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(1912930319));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(1912930380));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView = ((ExpandVoiceView)paramView.findViewById(1912930330));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(1912930308));
    this.f = ((ImageView)paramView.findViewById(1912930383));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(ProfileGuideDialogUtils.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setActivity(paramSquareItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b(true);
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
      if ((this.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).a(paramInt);
        return;
      }
      VasResDrawable localVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2130846313);
      localSignatureAdapter.a(true);
      localSignatureAdapter.a(new FeedViewHolder.1(this));
      localVasResDrawable.a(localSignatureAdapter);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localVasResDrawable);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt2;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
        localObject = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
        localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
        ((SignatureFontAdapter)localObject).a(localETTextView, localETTextView.getTextSize(), true);
        this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a((VasResAdapter)localObject);
        ((SignatureFontAdapter)localObject).a(-1);
        return;
      }
      localObject = (SignatureFontAdapter)((VasRes)localObject).a();
      ETTextView localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      ((SignatureFontAdapter)localObject).a(localETTextView, localETTextView.getTextSize(), true);
      ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(FeedViewHolder paramFeedViewHolder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if (paramStrangerInfo.mIsMyFeed)
    {
      paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramFeedViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramFeedViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (!paramStrangerInfo.mbAllowStrangerVote) {
      paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    Object localObject1 = paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView;
    if (TextUtils.isEmpty(paramStrangerInfo.mVoiceUrl)) {
      i = 8;
    } else {
      i = 0;
    }
    ((ExpandVoiceView)localObject1).setVisibility(i);
    int i = paramFeedViewHolder.getPosition();
    paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendFeedView.setFeedBgParams(i, paramStrangerInfo.mVoiceUrl, paramInt);
    paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceUrl(paramStrangerInfo.mVoiceUrl);
    paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceDuration(paramStrangerInfo.mVoiceDuration);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFaceFetch.a(paramStrangerInfo.mUin, paramStrangerInfo.mNickName, paramFeedViewHolder.jdField_a_of_type_AndroidWidgetImageView);
    paramFeedViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    paramFeedViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStrangerInfo.mNickName);
    paramFeedViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramStrangerInfo.mDeclaration), 3, 24));
    paramFeedViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
    localObject1 = paramFeedViewHolder.jdField_c_of_type_AndroidWidgetImageView;
    if (paramStrangerInfo.mLiked)
    {
      if (paramStrangerInfo.mAvailLikeCount == 0) {
        paramInt = 2130845146;
      } else {
        paramInt = 2130845145;
      }
    }
    else {
      paramInt = 2130845142;
    }
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
    if (((List)localObject1).size() > 0)
    {
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendLabelFlowLayout.setVisibility(0);
      localObject2 = paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandFeedExtendFriendLabelListAdapter;
      if (localObject2 != null) {
        ((ExtendFriendLabelListAdapter)localObject2).a();
      } else {
        paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandFeedExtendFriendLabelListAdapter = new ExtendFriendLabelListAdapter(BaseApplicationImpl.getContext());
      }
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandFeedExtendFriendLabelListAdapter.a(this.jdField_b_of_type_Boolean);
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandFeedExtendFriendLabelListAdapter.a((List)localObject1);
    }
    else
    {
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendLabelFlowLayout.setVisibility(8);
    }
    paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendLabelFlowLayout.setAdapter(paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqQqexpandFeedExtendFriendLabelListAdapter);
    if ((paramStrangerInfo.mSchoolInfos != null) && (paramStrangerInfo.mSchoolInfos.size() > 0))
    {
      localObject1 = (StrangerInfo.SchoolInfo)paramStrangerInfo.mSchoolInfos.get(0);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (!TextUtils.isEmpty(((StrangerInfo.SchoolInfo)localObject1).b)) {
          paramFeedViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StrangerInfo.SchoolInfo)localObject1).b);
        }
        if (((StrangerInfo.SchoolInfo)localObject1).a == 2L) {
          paramFeedViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845178);
        } else {
          paramFeedViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      paramFeedViewHolder = "1";
    } else {
      paramFeedViewHolder = "2";
    }
    VasWebviewUtil.a("strangers_makefriend", "plaza_show", "", 0, "", paramFeedViewHolder);
    paramFeedViewHolder = new HashMap();
    paramFeedViewHolder.put("feed_uid", paramStrangerInfo.mUin);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#voice_tab#feed", true, -1L, -1L, paramFeedViewHolder, true, true);
  }
  
  public void a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if (paramSignatureTemplateInfo == null) {
      return;
    }
    if ((paramSignatureTemplateInfo.e != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(paramSignatureTemplateInfo.e);
      ETTextView localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (localETTextView != null)
      {
        int i = this.jdField_a_of_type_Int;
        if (i != 0) {
          localETTextView.setTextColor(i);
        }
      }
    }
    if ((paramSignatureTemplateInfo.t != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.t)))
    {
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
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener != null)
    {
      long l = System.currentTimeMillis();
      if ((paramView.getId() != 1912930307) && (l - this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.a() < 500L)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.a(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131380981: 
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.c(i);
        return;
      case 1912930383: 
        VipUtils.a(paramView, (StrangerInfo)paramView.getTag());
        return;
      case 1912930329: 
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.a(i, 1);
        return;
      case 1912930314: 
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.a(i, 2);
        return;
      case 1912930308: 
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.f(i);
        return;
      case 1912930307: 
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.d(i);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.e(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FeedViewHolder
 * JD-Core Version:    0.7.0.1
 */