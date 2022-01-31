import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class qua
  implements qtv
{
  private qtu jdField_a_of_type_Qtu;
  private qtw jdField_a_of_type_Qtw;
  
  public qua(qtu paramqtu)
  {
    this.jdField_a_of_type_Qtu = paramqtu;
  }
  
  public int a()
  {
    return qok.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qtw = null;
  }
  
  public void a(@Nullable ColumnInfo paramColumnInfo, @NotNull qtm paramqtm)
  {
    if (QLog.isColorLevel())
    {
      if (paramColumnInfo != null) {
        QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic srcColumnInfo : " + paramColumnInfo.toString());
      }
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic columnPublishInfo : " + paramqtm.toString());
    }
    paramColumnInfo = new ColumnInfo(paramqtm);
    paramColumnInfo.source = 5;
    if (this.jdField_a_of_type_Qtw == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: editColumn view is null!");
      return;
    }
    this.jdField_a_of_type_Qtw.c();
    this.jdField_a_of_type_Qtu.b(paramColumnInfo, new qud(this, paramColumnInfo));
  }
  
  public void a(@NotNull qtm paramqtm)
  {
    ColumnInfo localColumnInfo = new ColumnInfo(paramqtm);
    this.jdField_a_of_type_Qtu.a(localColumnInfo);
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: saveColumnSketch column = " + paramqtm.toString());
    }
  }
  
  public void a(qtw paramqtw)
  {
    this.jdField_a_of_type_Qtw = paramqtw;
  }
  
  public void a(@NotNull qxd paramqxd, @NotNull String paramString)
  {
    if (this.jdField_a_of_type_Qtw != null) {
      this.jdField_a_of_type_Qtw.a();
    }
    paramqxd.a(new qub(this, paramString));
    paramqxd.a();
  }
  
  public int b()
  {
    return qok.b();
  }
  
  public void b()
  {
    ColumnInfo localColumnInfo = this.jdField_a_of_type_Qtu.a();
    if ((localColumnInfo != null) && (this.jdField_a_of_type_Qtw != null)) {
      this.jdField_a_of_type_Qtw.a(localColumnInfo);
    }
    if (QLog.isColorLevel())
    {
      if (localColumnInfo != null) {
        QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: initFromSketch bindTopicData column = " + localColumnInfo.toString());
      }
    }
    else {
      return;
    }
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: initFromSketch bindTopicData column is null.");
  }
  
  public void b(@NotNull qtm paramqtm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: createColumn columnPublishInfo : " + paramqtm.toString());
    }
    if (this.jdField_a_of_type_Qtw == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: createColumn view is null!");
      return;
    }
    paramqtm = new ColumnInfo(paramqtm);
    paramqtm.source = 5;
    this.jdField_a_of_type_Qtw.c();
    this.jdField_a_of_type_Qtu.a(paramqtm, new quc(this, paramqtm));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: clearColumnSketch.");
    }
    this.jdField_a_of_type_Qtu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qua
 * JD-Core Version:    0.7.0.1
 */