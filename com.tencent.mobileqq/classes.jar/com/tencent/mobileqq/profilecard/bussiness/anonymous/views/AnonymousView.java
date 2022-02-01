package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.manager.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AnonymousView
  extends ProfileContentTitleView
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  public static final String TAG = "AnonymousView";
  private AnonymousView.AnonymousAdapter anonymousAdapter;
  private List<AnonymousQuestion> anonymousInfoList = new ArrayList();
  public QQAppInterface appInterface;
  private boolean isTheme;
  private IFaceDecoder mFaceDecoder;
  private int randomHeadBgIndex;
  public RecyclerView recyclerView;
  private String uin;
  
  public AnonymousView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnonymousView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void clearRedPoint()
  {
    if (this.mTitleText.getCompoundDrawables() != null)
    {
      this.mTitleText.setCompoundDrawables(null, null, null, null);
      AnonymousRedPointUtils.cleanProfileRedPointGuide(this.appInterface);
    }
  }
  
  private void initViews()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(0);
    this.recyclerView = new RecyclerView(getContext());
    this.anonymousAdapter = new AnonymousView.AnonymousAdapter(this);
    this.recyclerView.setLayoutManager(localLinearLayoutManager);
    int i = AIOUtils.a(12.0F, getContext().getResources());
    this.recyclerView.addItemDecoration(new AnonymousView.SpacesItemDecoration(i, 0));
    this.recyclerView.setAdapter(this.anonymousAdapter);
    scrollEventListener();
    this.mTitleContainer.setOnClickListener(this);
  }
  
  private void scrollEventListener()
  {
    this.recyclerView.addOnItemTouchListener(new AnonymousView.1(this));
    this.recyclerView.addOnScrollListener(new AnonymousView.2(this));
  }
  
  public void destroy()
  {
    this.mFaceDecoder.setDecodeTaskCompletionListener(null);
    this.mFaceDecoder.destory();
    this.recyclerView.addOnScrollListener(null);
    this.recyclerView.addOnItemTouchListener(null);
    this.anonymousInfoList.clear();
    this.appInterface = null;
  }
  
  public Bitmap getFaceBitmap(long paramLong)
  {
    try
    {
      Bitmap localBitmap = this.mFaceDecoder.getBitmapFromCache(1, String.valueOf(paramLong));
      if (localBitmap != null) {
        return localBitmap;
      }
      if (!this.mFaceDecoder.isPausing()) {
        this.mFaceDecoder.requestDecodeFace(String.valueOf(paramLong), 200, true);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return ImageUtil.c();
  }
  
  public void init()
  {
    super.init();
    initViews();
  }
  
  public void initData(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    this.appInterface = paramQQAppInterface;
    this.isTheme = paramBoolean;
    this.uin = paramString;
    this.mFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.mFaceDecoder.setDecodeTaskCompletionListener(this);
    this.randomHeadBgIndex = ((int)(Math.random() * AnonymousConstant.headBgColor.length));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      clearRedPoint();
      AnonymousViewHelper.jumpToQuestionListAndAnswer((BaseActivity)this.mContext, this.uin, 1);
      ReportController.b(null, "dc00898", "", "", "0X800B46C", "0X800B46C", 0, 0, "", "", "", "");
      continue;
      clearRedPoint();
      AnonymousViewHelper.jumpToQuestionListAndAnswer((BaseActivity)this.mContext, this.uin, 2);
      ReportController.b(null, "dc00898", "", "", "0X800B46C", "0X800B46C", 0, 0, "", "", "", "");
      continue;
      clearRedPoint();
      AnonymousViewHelper.jumpToReqFriendAskQuestion((BaseActivity)this.mContext);
      ReportController.b(null, "dc00898", "", "", "0X800B46D", "0X800B46D", 0, 0, "", "", "", "");
      continue;
      clearRedPoint();
      AnonymousViewHelper.jumpToQuestionListAndAnswer((BaseActivity)this.mContext, this.uin, 3);
      ReportController.b(null, "dc00898", "", this.uin, "0X800B473", "0X800B473", 0, 0, "", "", "", "");
      continue;
      clearRedPoint();
      AnonymousViewHelper.jumpToAskQuestion((BaseActivity)this.mContext, this.uin, 6);
      ReportController.b(null, "dc00898", "", "", "0X800B472", "0X800B472", 0, 0, "", "", "", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.recyclerView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      Object localObject;
      int i;
      if (paramInt1 < paramInt2)
      {
        localObject = this.recyclerView.getChildAt(paramInt1);
        localObject = this.recyclerView.getChildViewHolder((View)localObject);
        if (!(localObject instanceof AnonymousView.ListViewHolder)) {
          break label123;
        }
        i = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
        if ((i >= 0) && (i < this.anonymousInfoList.size())) {}
      }
      else
      {
        return;
      }
      AnonymousQuestion localAnonymousQuestion = (AnonymousQuestion)this.anonymousInfoList.get(i);
      if ((localAnonymousQuestion != null) && (localAnonymousQuestion.mOwnerUin == Long.parseLong(paramString)) && (paramBitmap != null)) {
        ((AnonymousView.ListViewHolder)localObject).ivAnswer.setImageBitmap(paramBitmap);
      }
      label123:
      paramInt1 += 1;
    }
  }
  
  public void show(List<AnonymousQuestion> paramList)
  {
    removeContentViews();
    addContentView(this.recyclerView);
    this.anonymousInfoList.clear();
    this.anonymousInfoList.addAll(paramList);
    this.anonymousAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView
 * JD-Core Version:    0.7.0.1
 */