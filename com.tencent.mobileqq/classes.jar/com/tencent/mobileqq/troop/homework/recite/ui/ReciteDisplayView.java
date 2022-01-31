package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ReciteDisplayView
  extends ListView
{
  private long jdField_a_of_type_Long;
  private ArticleInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo;
  public WordInfo a;
  private ReciteFragment jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment;
  private boolean jdField_a_of_type_Boolean;
  
  public ReciteDisplayView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReciteDisplayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReciteDisplayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null)) {}
    while ((paramInt < 0) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size() - 1)) {
      return 0;
    }
    return ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(paramInt)).generateOrGetWordInfoList(paramInt).size();
  }
  
  public WordInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.b() == 0)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ReciteDisplayView", 2, "背诵课文刷新, scrool2Y = " + paramFloat + ", mReciteDisplayView.getBottom() = " + getBottom() + ", mIsTouchMove = " + this.jdField_a_of_type_Boolean);
        }
      } while ((this.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 3000L));
      smoothScrollByOffset((int)paramFloat - getBottom());
    } while (!QLog.isColorLevel());
    QLog.i("ReciteDisplayView", 2, "背诵课文自动滚动到, scrool2Y：" + paramFloat);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Boolean = true;
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void setArticleInfo(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = paramArticleInfo;
  }
  
  public void setFragment(ReciteFragment paramReciteFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment = paramReciteFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteDisplayView
 * JD-Core Version:    0.7.0.1
 */