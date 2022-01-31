package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XPanelContainer;

public class EmotionDownloadOrInvalidAdapter
  extends EmotionDownloadOrUpdateAdapter
  implements View.OnClickListener
{
  protected int f;
  
  public EmotionDownloadOrInvalidAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.b = false;
    this.f = (XPanelContainer.a - (int)paramContext.getResources().getDimension(2131558705));
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder = ((EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder)paramViewHolder);
    if (paramView == null)
    {
      paramViewHolder = EmotionPanelViewPool.a().a(this.c);
      paramView = new AbsListView.LayoutParams(-1, this.f);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form inflater");
        }
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970899, null);
        paramViewHolder.setLayoutParams(paramView);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewHolder.findViewById(2131364453));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131364458));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramViewHolder.findViewById(2131364459));
        a(this.c, paramViewHolder);
        paramViewHolder.setTag(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder);
      return paramViewHolder;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownloadOrInvalidAdapter", 2, "getEmotionView position = " + paramInt + ";view form cache");
      }
      break;
      paramViewHolder = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public int getCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrInvalidAdapter
 * JD-Core Version:    0.7.0.1
 */