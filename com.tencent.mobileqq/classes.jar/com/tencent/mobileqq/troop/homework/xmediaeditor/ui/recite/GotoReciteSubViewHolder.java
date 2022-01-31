package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import ajte;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;
import java.util.List;
import org.json.JSONObject;

public class GotoReciteSubViewHolder
  extends ReciteSubViewHolderBase
{
  private TextView a;
  private TextView b;
  
  public GotoReciteSubViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368468));
    this.b = ((TextView)paramView.findViewById(2131368469));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, ajte paramajte)
  {
    paramHWReciteItem = (HWReciteInfo)paramajte.a;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReciteFragment.a(paramView.getContext(), paramHWReciteItem.a().toString(), paramHWReciteItem.jdField_c_of_type_Int);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramView instanceof QQAppInterface));
    paramView = (QQAppInterface)paramView;
    TroopReportor.a("Grp_edu", "Grp_recite", "Recite_Clk", 0, 0, new String[] { paramHWReciteItem.f, TroopReportor.a(paramView, paramHWReciteItem.f, paramView.getCurrentAccountUin()), paramHWReciteItem.b });
  }
  
  public void a(HWReciteItem paramHWReciteItem, ajte paramajte, HWReciteInfo paramHWReciteInfo, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(paramHWReciteInfo.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder("在线背诵").append(paramHWReciteInfo.b);
      if ((paramHWReciteInfo.a != null) && (!paramHWReciteInfo.a.isEmpty())) {
        localStringBuilder.append(HWReciteUtils.a(paramHWReciteInfo.a));
      }
      paramHWReciteInfo.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramHWReciteInfo.jdField_c_of_type_JavaLangString);
    paramHWReciteItem.b(this.jdField_a_of_type_AndroidViewView, paramajte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.GotoReciteSubViewHolder
 * JD-Core Version:    0.7.0.1
 */