package com.tencent.mobileqq.teamworkforgroup;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

class TroopTeamWorkFileSearchDialog$9
  extends GroupTeamWorkObserver
{
  TroopTeamWorkFileSearchDialog$9(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public void a(boolean paramBoolean1, int paramInt1, String arg3, List<GPadInfo> paramList, int paramInt2, boolean paramBoolean2)
  {
    ??? = this.a;
    ???.jdField_a_of_type_Int -= 1;
    if ((paramBoolean1) && (paramInt1 == 0)) {
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        if (this.a.jdField_a_of_type_JavaUtilList != null) {
          this.a.jdField_a_of_type_JavaUtilList.clear();
        } else {
          this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        ??? = this.a;
        ???.c = paramInt2;
        ???.e = paramBoolean2;
        if (paramList != null)
        {
          ???.jdField_b_of_type_Int = paramList.size();
          synchronized (this.a.jdField_a_of_type_JavaLangObject)
          {
            this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
            ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(???);
            return;
          }
        }
      }
    }
    if (this.a.jdField_b_of_type_Boolean) {
      ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    } else {
      ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.9
 * JD-Core Version:    0.7.0.1
 */