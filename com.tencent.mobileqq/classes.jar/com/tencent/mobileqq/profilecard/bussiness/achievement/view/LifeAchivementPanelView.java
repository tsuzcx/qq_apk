package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementHandler;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LifeAchivementPanelView
  extends ProfileContentTitleView
{
  static final String ADD_BADGE_URL = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
  static final String DEFAULT_BADGE_URL = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
  static final String EMPTY_VIEW_BACKGROUND_URL = "https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png";
  static final String TAG = "LifeAchivementPanelView";
  LifeAchivementAdapter achivementAdapter;
  RecyclerView achivementList;
  Button addAchivementBtn;
  RelativeLayout emptyView;
  private boolean isFriend;
  private boolean isSelf;
  LifeAchivementAdapter.OnItemClickListener itemClickListener;
  LifeAchievementHandler lifeAchievementHandler;
  String userOpenID;
  long userUin;
  
  public LifeAchivementPanelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LifeAchivementPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void initAchivementList()
  {
    this.achivementList = new RecyclerView(getContext());
    this.achivementList.addOnItemTouchListener(new LifeAchivementPanelView.3(this));
    this.achivementList.addOnScrollListener(new LifeAchivementPanelView.4(this));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.achivementList.setLayoutManager(localLinearLayoutManager);
    int i = Utils.a(5.0F, getResources());
    int j = Utils.a(0.0F, getResources());
    this.achivementList.addItemDecoration(new LifeAchivementAdapter.SpacesItemDecoration(i, j));
    this.itemClickListener = new LifeAchivementPanelView.5(this);
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "init ");
    }
    this.achivementAdapter = new LifeAchivementAdapter(getContext(), null, this.itemClickListener);
    this.achivementList.setAdapter(this.achivementAdapter);
  }
  
  private void updateLocalPraiseData(LifeAchivementData paramLifeAchivementData, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramLifeAchivementData.hasPraised = true;
      paramLifeAchivementData.praiseNum += 1;
    }
    else if (paramInt2 == 2)
    {
      paramLifeAchivementData.hasPraised = false;
      paramLifeAchivementData.praiseNum -= 1;
    }
    this.achivementAdapter.notifyItemChanged(paramInt1);
  }
  
  protected void init()
  {
    super.init();
    this.emptyView = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561349, this, false));
    this.addAchivementBtn = ((Button)this.emptyView.findViewById(2131369711));
    this.addAchivementBtn.setOnClickListener(new LifeAchivementPanelView.1(this));
    URLImageView localURLImageView = (URLImageView)this.emptyView.findViewById(2131369710);
    if (localURLImageView != null)
    {
      localURLImageView.setImageURL("https://downv6.qq.com/qq_relation/life_achivement/lifeachivement_empty_bg.png");
      localURLImageView.setVisibility(0);
    }
    initAchivementList();
    this.mTitleContainer.setOnClickListener(new LifeAchivementPanelView.2(this));
    this.mTitleContainer.setContentDescription(getResources().getString(2131691185));
  }
  
  public void setLifeAchievementHandler(LifeAchievementHandler paramLifeAchievementHandler)
  {
    this.lifeAchievementHandler = paramLifeAchievementHandler;
  }
  
  public void showAchivementList(ArrayList<LifeAchivementData> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAchivementList dataArrayList.size() = ");
      localStringBuilder.append(paramArrayList.size());
      localStringBuilder.append(",totalCount = ");
      localStringBuilder.append(paramInt);
      QLog.d("LifeAchivementPanelView", 2, localStringBuilder.toString());
    }
    removeContentViews();
    addContentView(this.achivementList);
    boolean bool = this.isSelf;
    this.achivementAdapter.updateDatas(paramArrayList, paramInt, bool);
  }
  
  public void showEmptyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "showEmptyView");
    }
    removeContentViews();
    addContentView(this.emptyView);
  }
  
  public void updateUserInfo(ProfileCardInfo paramProfileCardInfo, Card paramCard, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    boolean bool2 = ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne);
    long l1 = 0L;
    boolean bool1 = true;
    try
    {
      long l2 = Long.valueOf(paramCard.uin).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramCard)
    {
      QLog.d("LifeAchivementPanelView", 1, "updateUserInfo exception ", paramCard);
    }
    if (paramProfileCardInfo.allInOne.pa != 0) {
      bool1 = false;
    }
    this.isFriend = bool2;
    this.userOpenID = paramString;
    this.isSelf = bool1;
    this.userUin = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView
 * JD-Core Version:    0.7.0.1
 */