package com.tencent.mobileqq.troop.homework.recite.ui;

import aiuc;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import java.util.ArrayList;
import java.util.List;

public class ReciteDisplayView$MyArticleAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int = 1;
  Context jdField_a_of_type_AndroidContentContext;
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public ReciteDisplayView$MyArticleAdapter(ReciteDisplayView paramReciteDisplayView, Context paramContext, List paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = paramReciteDisplayView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = UITools.b(paramContext);
    int i = paramList.size() - 1;
    while (i > 0)
    {
      paramReciteDisplayView = (ParagraphInfo)paramList.get(i);
      paramReciteDisplayView.paragraphPos = i;
      if ((TextUtils.isEmpty(paramReciteDisplayView.content_html)) && (TextUtils.isEmpty(paramReciteDisplayView.content_pinyin))) {
        paramList.remove(i);
      }
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(i)).setWordColor(3);
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void a(WordInfo paramWordInfo)
  {
    if ((paramWordInfo == null) || (paramWordInfo.paragraphPos < 0) || (paramWordInfo.wordPos < 0) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    ParagraphInfo localParagraphInfo;
    if (this.jdField_a_of_type_JavaUtilList.size() < paramWordInfo.paragraphPos + 1)
    {
      localParagraphInfo = new ParagraphInfo();
      localParagraphInfo.wordList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(localParagraphInfo);
      localParagraphInfo.wordList.add(paramWordInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a = paramWordInfo;
      notifyDataSetChanged();
      return;
      localParagraphInfo = (ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(paramWordInfo.paragraphPos);
      if (paramWordInfo.wordPos < localParagraphInfo.wordList.size()) {
        ((WordInfo)localParagraphInfo.wordList.get(paramWordInfo.wordPos)).color = paramWordInfo.color;
      } else {
        localParagraphInfo.wordList.add(paramWordInfo);
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = new aiuc(null);
      paramView.a = new PinyinTextView(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
      paramViewGroup = paramView.a;
      paramViewGroup.setTag(paramView);
    }
    paramView = (aiuc)paramViewGroup.getTag();
    ParagraphInfo localParagraphInfo = (ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView.a.setWordInfos(localParagraphInfo);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteDisplayView.MyArticleAdapter
 * JD-Core Version:    0.7.0.1
 */