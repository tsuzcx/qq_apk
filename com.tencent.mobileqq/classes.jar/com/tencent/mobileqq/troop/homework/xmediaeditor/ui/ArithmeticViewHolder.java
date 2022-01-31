package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcdv;
import bcdw;
import bcex;
import bdes;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithmeticCaptureTransferFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ArithmeticViewHolder
  extends bcex<bcdv>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-2631721);
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcdv jdField_a_of_type_Bcdv;
  private XMediaEditor jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<bcdw, ArithmeticViewHolder.ArithmeticImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ArithmeticViewHolder.ArithmeticImageView> jdField_a_of_type_JavaUtilList = new ArrayList(6);
  private LinearLayout b;
  private LinearLayout c;
  
  public ArithmeticViewHolder(XMediaEditor paramXMediaEditor, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = paramXMediaEditor;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a("troopuin");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367243));
    this.b = ((LinearLayout)paramView.findViewById(2131364788));
    this.c = ((LinearLayout)paramView.findViewById(2131368131));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364806));
    int i = 0;
    while (i < 6)
    {
      paramXMediaEditor = new ArithmeticViewHolder.ArithmeticImageView(this, this.b.getContext());
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.setMargins(0, 10, 0, 0);
      this.c.addView(paramXMediaEditor, paramView);
      this.jdField_a_of_type_JavaUtilList.add(paramXMediaEditor);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bcdv != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(this.jdField_a_of_type_Bcdv.c);
    }
  }
  
  private void a(ArithmeticViewHolder.ArithmeticImageView paramArithmeticImageView, bcdw parambcdw)
  {
    switch (parambcdw.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
      paramArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambcdw.jdField_a_of_type_Int, parambcdw.jdField_b_of_type_JavaLangString);
      return;
    case 2: 
      paramArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      paramArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    paramArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(bcdv parambcdv, int paramInt)
  {
    if (paramInt != 2)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Bcdv = parambcdv;
    int i = parambcdv.c();
    HashMap localHashMap = new HashMap();
    if (i == 0)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    i = 0;
    for (;;)
    {
      bcdw localbcdw;
      ArithmeticViewHolder.ArithmeticImageView localArithmeticImageView;
      if (i < 6)
      {
        localbcdw = parambcdv.a(i);
        localArithmeticImageView = (ArithmeticViewHolder.ArithmeticImageView)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localbcdw != null) {}
      }
      else
      {
        paramInt = i;
        while (paramInt < 6)
        {
          ((ArithmeticViewHolder.ArithmeticImageView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b();
          paramInt += 1;
        }
      }
      localArithmeticImageView.a(localbcdw, paramInt);
      localHashMap.put(localbcdw, localArithmeticImageView);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    if (i < 6) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcdv.a();
      a(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArithmeticViewHolder", 2, "bind view , picture size = " + i);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Bcdv.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bcdw)localIterator.next();
      if ((((bcdw)localObject).jdField_b_of_type_Int == -1) || (((bcdw)localObject).jdField_b_of_type_Int == 0) || ((paramBoolean) && (((bcdw)localObject).jdField_b_of_type_Int == 2)))
      {
        localObject = (ArithmeticViewHolder.ArithmeticImageView)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if (localObject != null) {
          ((ArithmeticViewHolder.ArithmeticImageView)localObject).a();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367243: 
      bdes.a("Grp_edu", "Grp_oral", "Oral_Clk", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
      ArithmeticCaptureTransferFragment.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), this.jdField_a_of_type_Bcdv.a(1).toString(), this.jdField_a_of_type_Bcdv.c, this.jdField_a_of_type_JavaLangString);
      return;
    }
    bdes.a("Grp_edu", "Grp_oral", "Finish_Oral_Again", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
    ArithmeticCaptureTransferFragment.a(paramView.getContext(), this.jdField_a_of_type_Bcdv.a(1).toString(), this.jdField_a_of_type_Bcdv.c, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder
 * JD-Core Version:    0.7.0.1
 */