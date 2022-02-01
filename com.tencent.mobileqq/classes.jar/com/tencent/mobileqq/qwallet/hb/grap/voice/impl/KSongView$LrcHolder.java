package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.qqpay.ui.R.id;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class KSongView$LrcHolder
  implements QwAdapter.IViewHolder<Sentence>
{
  public KSongTextView a;
  
  public KSongView$LrcHolder(KSongView paramKSongView) {}
  
  public void a(int paramInt, View paramView, Sentence paramSentence)
  {
    this.a.a();
    KSongTextView localKSongTextView = this.a;
    if (TextUtils.isEmpty(paramSentence.a)) {
      paramView = "";
    } else {
      paramView = paramSentence.a;
    }
    localKSongTextView.setText(paramView);
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.a = ((KSongTextView)paramView.findViewById(R.id.bB));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView.LrcHolder
 * JD-Core Version:    0.7.0.1
 */