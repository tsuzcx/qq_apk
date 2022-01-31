package com.tencent.mobileqq.datareportviewer;

import alpo;
import apcm;
import apcn;
import apde;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class DataReportSettingFragment$4$1
  implements Runnable
{
  public DataReportSettingFragment$4$1(apcm paramapcm, ArrayList paramArrayList) {}
  
  public void run()
  {
    apde.a().a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Apcm.a.a.notifyDataSetChanged();
    QQToast.a(this.jdField_a_of_type_Apcm.a.getActivity(), alpo.a(2131703150), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */