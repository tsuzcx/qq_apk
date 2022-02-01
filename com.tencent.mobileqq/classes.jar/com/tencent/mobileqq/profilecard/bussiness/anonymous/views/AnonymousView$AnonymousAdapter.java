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
import com.tencent.TMG.utils.QLog;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementHelper;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
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
    String str = this.this$0.getContext().getString(2131698557);
    Object localObject;
    if (localAnonymousQuestion.mTotalViewCount > 0L)
    {
      localObject = LifeAchivementHelper.a((int)localAnonymousQuestion.mTotalViewCount);
      localTextView.setText(String.format(str, new Object[] { localObject }));
      if (ThemeUtil.isInNightMode(this.this$0.appInterface))
      {
        paramListViewHolder.ll.setBackgroundResource(2130846034);
        paramListViewHolder.rl.setBackgroundResource(2130846023);
      }
      if (!SimpleUIUtil.a()) {
        break label317;
      }
      paramListViewHolder.ivQues.setImageResource(2130846040);
      paramListViewHolder.ivQuesHeadBg.setImageResource(2130846037);
      paramListViewHolder.ivQuesHeadCircle.setImageResource(2130846039);
      paramListViewHolder.ivAnswerHeadCircle.setImageResource(2130846025);
    }
    for (;;)
    {
      int i = AnonymousView.access$300(this.this$0);
      int j = AnonymousConstant.headBgColor.length;
      paramListViewHolder.ivQuesHeadBg.clearColorFilter();
      paramListViewHolder.ivQuesHeadBg.setColorFilter(AnonymousConstant.headBgColor[((i + paramInt) % j)]);
      setLikeUi(localAnonymousQuestion.mPraised, paramListViewHolder.tvLike, paramListViewHolder.ivLike, localAnonymousQuestion.mTotalPraiseCount);
      paramListViewHolder.tvComment.setText(LifeAchivementHelper.a((int)localAnonymousQuestion.mTotalCommentCount));
      bindEventListener(localAnonymousQuestion, paramListViewHolder);
      return;
      localObject = Long.valueOf(localAnonymousQuestion.mTotalViewCount);
      break;
      label317:
      paramListViewHolder.ivQues.setImageResource(2130846035);
      paramListViewHolder.ivQuesHeadBg.setImageResource(2130846036);
      paramListViewHolder.ivQuesHeadCircle.setImageResource(2130846038);
      paramListViewHolder.ivAnswerHeadCircle.setImageResource(2130846024);
    }
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
    Drawable localDrawable = this.this$0.getContext().getResources().getDrawable(2130846103);
    int i = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localDrawable = this.this$0.getContext().getResources().getDrawable(2130846029);
      i = AnonymousConstant.likeTvColor;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousView", 0, String.format("setLikeUi() mPraised=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    paramTextView.setText(LifeAchivementHelper.a((int)paramLong));
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
    if ((paramViewHolder instanceof AnonymousView.VisitorEmptyViewHolder))
    {
      ((AnonymousView.VisitorEmptyViewHolder)paramViewHolder).button.setOnClickListener(this.this$0);
      needShowEmptyView((URLImageView)((AnonymousView.VisitorEmptyViewHolder)paramViewHolder).imageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if ((paramViewHolder instanceof AnonymousView.HostEmptyQuestionViewHolder))
      {
        ((AnonymousView.HostEmptyQuestionViewHolder)paramViewHolder).button.setOnClickListener(this.this$0);
        needShowEmptyView((URLImageView)((AnonymousView.HostEmptyQuestionViewHolder)paramViewHolder).imageView, "https://sola.gtimg.cn/aoi/sola/20200804163900_erRdzraqzD.png");
      }
      else if ((paramViewHolder instanceof AnonymousView.HostEmptyAnswerViewHolder))
      {
        ((AnonymousView.HostEmptyAnswerViewHolder)paramViewHolder).button.setOnClickListener(this.this$0);
        needShowEmptyView((URLImageView)((AnonymousView.HostEmptyAnswerViewHolder)paramViewHolder).imageView, "https://sola.gtimg.cn/aoi/sola/20200804163807_LtSTnieZwI.png");
      }
      else if ((paramViewHolder instanceof AnonymousView.VisitorAskQuestionViewHolder))
      {
        ((AnonymousView.VisitorAskQuestionViewHolder)paramViewHolder).viewAskQues.setOnClickListener(this.this$0);
        if (ThemeUtil.isInNightMode(this.this$0.appInterface)) {
          ((AnonymousView.VisitorAskQuestionViewHolder)paramViewHolder).ll.setBackgroundResource(2130846028);
        }
      }
      else if ((paramViewHolder instanceof AnonymousView.HostShowTotalViewHolder))
      {
        ((AnonymousView.HostShowTotalViewHolder)paramViewHolder).viewTotal.setOnClickListener(this.this$0);
        if (ThemeUtil.isInNightMode(this.this$0.appInterface)) {
          ((AnonymousView.HostShowTotalViewHolder)paramViewHolder).ll.setBackgroundResource(2130846028);
        }
      }
      else
      {
        bindQuesDataToUI((AnonymousView.ListViewHolder)paramViewHolder, paramInt);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (4 == paramInt) {
      return new AnonymousView.VisitorEmptyViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561464, paramViewGroup, false));
    }
    if (5 == paramInt) {
      return new AnonymousView.VisitorAskQuestionViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561463, paramViewGroup, false));
    }
    if (1 == paramInt) {
      return new AnonymousView.HostEmptyQuestionViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561460, paramViewGroup, false));
    }
    if (2 == paramInt) {
      return new AnonymousView.HostEmptyAnswerViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561459, paramViewGroup, false));
    }
    if (3 == paramInt) {
      return new AnonymousView.HostShowTotalViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561461, paramViewGroup, false));
    }
    return new AnonymousView.ListViewHolder(LayoutInflater.from(this.this$0.getContext()).inflate(2131561462, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter
 * JD-Core Version:    0.7.0.1
 */