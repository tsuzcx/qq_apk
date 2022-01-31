import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.biz.troop.file.TroopFileProtocol.CreateFolderObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class pdc
  extends TroopFileProtocol.CreateFolderObserver
{
  public pdc(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, TroopFileInfo paramTroopFileInfo)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131558448);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, paramTroopFileInfo);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130838514);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131624424);
      MoveFileActivity.a(this.a).i(paramTroopFileInfo);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", paramTroopFileInfo.b, "", "");
      QQToast.a(this.a.getActivity(), 2, "创建成功", 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramTroopFileInfo = this.a.getString(2131430232);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
    case -313: 
      paramTroopFileInfo = this.a.getString(2131429717);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131429708), null, this.a.jdField_a_of_type_JavaLangString, paramTroopFileInfo);
      return;
      paramTroopFileInfo = this.a.getString(2131429718);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      paramTroopFileInfo = this.a.getString(2131429720);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
      paramTroopFileInfo = this.a.getString(2131429722);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
      paramTroopFileInfo = this.a.getString(2131429719);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdc
 * JD-Core Version:    0.7.0.1
 */