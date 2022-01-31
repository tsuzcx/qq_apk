package com.tencent.mobileqq.datareportviewer;

import alud;
import apgv;
import apgw;
import aphn;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class DataReportSettingFragment$4$1
  implements Runnable
{
  public DataReportSettingFragment$4$1(apgv paramapgv, ArrayList paramArrayList) {}
  
  public void run()
  {
    aphn.a().a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Apgv.a.a.notifyDataSetChanged();
    QQToast.a(this.jdField_a_of_type_Apgv.a.getActivity(), alud.a(2131703162), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */