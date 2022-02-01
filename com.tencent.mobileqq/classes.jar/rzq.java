import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class rzq
  implements rzl
{
  private rzk jdField_a_of_type_Rzk;
  private rzm jdField_a_of_type_Rzm;
  
  public rzq(rzk paramrzk)
  {
    this.jdField_a_of_type_Rzk = paramrzk;
  }
  
  public int a()
  {
    return rth.d();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rzm = null;
  }
  
  public void a(int paramInt, @NotNull rza paramrza)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic srcColumnInfo.columnId : " + paramInt);
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic columnPublishInfo : " + paramrza.toString());
    }
    paramrza = new ColumnInfo(paramrza);
    paramrza.columnID = paramInt;
    paramrza.source = 5;
    if (this.jdField_a_of_type_Rzm == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: editColumn view is null!");
      return;
    }
    this.jdField_a_of_type_Rzm.c();
    this.jdField_a_of_type_Rzk.b(paramrza, new rzt(this, paramrza));
  }
  
  public void a(@NotNull rza paramrza)
  {
    ColumnInfo localColumnInfo = new ColumnInfo(paramrza);
    this.jdField_a_of_type_Rzk.a(localColumnInfo);
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: saveColumnSketch column = " + paramrza.toString());
    }
  }
  
  public void a(rzm paramrzm)
  {
    this.jdField_a_of_type_Rzm = paramrzm;
  }
  
  public void a(@NotNull sdn paramsdn, @NotNull String paramString)
  {
    if (this.jdField_a_of_type_Rzm != null) {
      this.jdField_a_of_type_Rzm.a();
    }
    paramsdn.a(new rzr(this, paramString));
    paramsdn.a();
  }
  
  public int b()
  {
    return rth.e();
  }
  
  public void b()
  {
    ColumnInfo localColumnInfo = this.jdField_a_of_type_Rzk.a();
    if ((localColumnInfo != null) && (this.jdField_a_of_type_Rzm != null)) {
      this.jdField_a_of_type_Rzm.a(localColumnInfo);
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
  
  public void b(@NotNull rza paramrza)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: createColumn columnPublishInfo : " + paramrza.toString());
    }
    if (this.jdField_a_of_type_Rzm == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: createColumn view is null!");
      return;
    }
    paramrza = new ColumnInfo(paramrza);
    paramrza.source = 5;
    this.jdField_a_of_type_Rzm.c();
    this.jdField_a_of_type_Rzk.a(paramrza, new rzs(this, paramrza));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: clearColumnSketch.");
    }
    this.jdField_a_of_type_Rzk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzq
 * JD-Core Version:    0.7.0.1
 */