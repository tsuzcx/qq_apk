package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.List;

public class AnonymousView$AnonymousAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  protected AnonymousView$AnonymousAdapter(AnonymousView paramAnonymousView) {}
  
  private void bindEventListener(AnonymousQuestion paramAnonymousQuestion, AnonymousView.ListViewHolder paramListViewHolder)
  {
    paramAnonymousQuestion = new AnonymousView.AnonymousAdapter.1(this, paramAnonymousQuestion, paramListViewHolder);
    paramListViewHolder.tvLike.setOnClickListener(paramAnonymousQuestion);
    paramListViewHolder.ivLike.setOnClickListener(paramAnonymousQuestion);
    paramListViewHolder.tvComment.setOnClickListener(paramAnonymousQuestion);
    paramListViewHolder.ivComment.setOnClickListener(paramAnonymousQuestion);
    paramListViewHolder.tvBrowse.setOnClickListener(paramAnonymousQuestion);
    paramListViewHolder.ivBrowser.setOnClickListener(paramAnonymousQuestion);
    paramListViewHolder.tvComment.setOnTouchListener(UITools.a);
    paramListViewHolder.ivComment.setOnTouchListener(UITools.a);
    paramListViewHolder.root.setOnClickListener(paramAnonymousQuestion);
  }
  
  private void bindQuesDataToUI(AnonymousView.ListViewHolder paramListViewHolder, int paramInt)
  {
    AnonymousQuestion localAnonymousQuestion = (AnonymousQuestion)AnonymousView.access$100(this.this$0).get(paramInt);
    paramListViewHolder.tvQues.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(localAnonymousQuestion.mQuest), 3, 16));
    paramListViewHolder.tvAnswer.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(localAnonymousQuestion.mAnswer), 3, 16));
    paramListViewHolder.ivAnswer.setImageBitmap(this.this$0.getFaceBitmap(localAnonymousQuestion.mOwnerUin));
    TextView localTextView = paramListViewHolder.tvBrowse;
    String str = this.this$0.getContext().getString(2131698623);
    Object localObject;
    if (localAnonymousQuestion.mTotalViewCount > 0L) {
      localObject = ProfileUtils.formatPraiseNum((int)localAnonymousQuestion.mTotalViewCount);
    } else {
      localObject = Long.valueOf(localAnonymousQuestion.mTotalViewCount);
    }
    localTextView.setText(String.format(str, new Object[] { localObject }));
    if (ThemeUtil.isInNightMode(this.this$0.appInterface))
    {
      paramListViewHolder.ll.setBackgroundResource(2130845909);
      paramListViewHolder.rl.setBackgroundResource(2130845898);
    }
    if (SimpleUIUtil.a())
    {
      paramListViewHolder.ivQues.setImageResource(2130845915);
      paramListViewHolder.ivQuesHeadBg.setImageResource(2130845912);
      paramListViewHolder.ivQuesHeadCircle.setImageResource(2130845914);
      paramListViewHolder.ivAnswerHeadCircle.setImageResource(2130845900);
    }
    else
    {
      paramListViewHolder.ivQues.setImageResource(2130845910);
      paramListViewHolder.ivQuesHeadBg.setImageResource(2130845911);
      paramListViewHolder.ivQuesHeadCircle.setImageResource(2130845913);
      paramListViewHolder.ivAnswerHeadCircle.setImageResource(2130845899);
    }
    int i = AnonymousView.access$300(this.this$0);
    int j = AnonymousConstant.HEAD_BG_COLOR.length;
    paramListViewHolder.ivQuesHeadBg.clearColorFilter();
    paramListViewHolder.ivQuesHeadBg.setColorFilter(AnonymousConstant.HEAD_BG_COLOR[((i + paramInt) % j)]);
    setLikeUi(localAnonymousQuestion.mPraised, paramListViewHolder.tvLike, paramListViewHolder.ivLike, localAnonymousQuestion.mTotalPraiseCount);
    paramListViewHolder.tvComment.setText(ProfileUtils.formatPraiseNum((int)localAnonymousQuestion.mTotalCommentCount));
    bindEventListener(localAnonymousQuestion, paramListViewHolder);
  }
  
  private boolean needShowEmptyView(URLImageView paramURLImageView, String paramString)
  {
    if (((AnonymousView.access$200(this.this$0)) || (ThemeUtil.isInNightMode(this.this$0.appInterface))) && (paramURLImageView != null))
    {
      paramURLImageView.setVisibility(4);
      return false;
    }
    if ((paramURLImageView != null) && (paramString != null)) {
      paramURLImageView.setImageURL(paramString);
    }
    return true;
  }
  
  private void setLikeUi(boolean paramBoolean, TextView paramTextView, ImageView paramImageView, long paramLong)
  {
    Drawable localDrawable = this.this$0.getContext().getResources().getDrawable(2130845981);
    int i = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localDrawable = this.this$0.getContext().getResources().getDrawable(AnonymousConstant.LIKE_IV_DRAWABLE);
      i = AnonymousConstant.LIKE_IV_COLOR;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousView", 2, String.format("setLikeUi() mPraised=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    paramTextView.setText(ProfileUtils.formatPraiseNum((int)paramLong));
    paramTextView.setTextColor(i);
    paramImageView.setImageDrawable(localDrawable);
  }
  
  public int getItemCount()
  {
    return AnonymousView.access$100(this.this$0).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((AnonymousQuestion)AnonymousView.access$100(this.this$0).get(paramInt)).uiState;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    if ((paramViewHolder instanceof AnonymousView.VisitorEmptyViewHolder))
    {
      localObject = (AnonymousView.VisitorEmptyViewHolder)paramViewHolder;
      ((AnonymousView.VisitorEmptyViewHolder)localObject).button.setOnClickListener(this.this$0);
      needShowEmptyView((URLImageView)((AnonymousView.VisitorEmptyViewHolder)localObject).imageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
    }
    else if ((paramViewHolder instanceof AnonymousView.HostEmptyQuestionViewHolder))
    {
      localObject = (AnonymousView.HostEmptyQuestionViewHolder)paramViewHolder;
      ((AnonymousView.HostEmptyQuestionViewHolder)localObject).button.setOnClickListener(this.this$0);
      needShowEmptyView((URLImageView)((AnonymousView.HostEmptyQuestionViewHolder)localObject).imageView, "https://sola.gtimg.cn/aoi/sola/20200804163900_erRdzraqzD.png");
    }
    else if ((paramViewHolder instanceof AnonymousView.HostEmptyAnswerViewHolder))
    {
      localObject = (AnonymousView.HostEmptyAnswerViewHolder)paramViewHolder;
      ((AnonymousView.HostEmptyAnswerViewHolder)localObject).button.setOnClickListener(this.this$0);
      needShowEmptyView((URLImageView)((AnonymousView.HostEmptyAnswerViewHolder)localObject).imageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
    }
    else if ((paramViewHolder instanceof AnonymousView.VisitorAskQuestionViewHolder))
    {
      localObject = (AnonymousView.VisitorAskQuestionViewHolder)paramViewHolder;
      ((AnonymousView.VisitorAskQuestionViewHolder)localObject).viewAskQues.setOnClickListener(this.this$0);
      if (ThemeUtil.isInNightMode(this.this$0.appInterface)) {
        ((AnonymousView.VisitorAskQuestionViewHolder)localObject).ll.setBackgroundResource(2130845903);
      }
    }
    else if ((paramViewHolder instanceof AnonymousView.HostShowTotalViewHolder))
    {
      localObject = (AnonymousView.HostShowTotalViewHolder)paramViewHolder;
      ((AnonymousView.HostShowTotalViewHolder)localObject).viewTotal.setOnClickListener(this.this$0);
      if (ThemeUtil.isInNightMode(this.this$0.appInterface)) {
        ((AnonymousView.HostShowTotalViewHolder)localObject).ll.setBackgroundResource(2130845903);
      }
    }
    else
    {
      bindQuesDataToUI((AnonymousView.ListViewHolder)paramViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (4 == paramInt) {
      return new AnonymousView.VisitorEmptyViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561307, paramViewGroup, false));
    }
    if (5 == paramInt) {
      return new AnonymousView.VisitorAskQuestionViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561306, paramViewGroup, false));
    }
    if (1 == paramInt) {
      return new AnonymousView.HostEmptyQuestionViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561303, paramViewGroup, false));
    }
    if (2 == paramInt) {
      return new AnonymousView.HostEmptyAnswerViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561302, paramViewGroup, false));
    }
    if (3 == paramInt) {
      return new AnonymousView.HostShowTotalViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561304, paramViewGroup, false));
    }
    return new AnonymousView.ListViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561305, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter
 * JD-Core Version:    0.7.0.1
 */