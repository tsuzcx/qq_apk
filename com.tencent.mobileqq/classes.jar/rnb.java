import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class rnb
  implements rmw
{
  private rmv jdField_a_of_type_Rmv;
  private rmx jdField_a_of_type_Rmx;
  
  public rnb(rmv paramrmv)
  {
    this.jdField_a_of_type_Rmv = paramrmv;
  }
  
  public int a()
  {
    return rha.d();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rmx = null;
  }
  
  public void a(int paramInt, @NotNull rml paramrml)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic srcColumnInfo.columnId : " + paramInt);
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic columnPublishInfo : " + paramrml.toString());
    }
    paramrml = new ColumnInfo(paramrml);
    paramrml.columnID = paramInt;
    paramrml.source = 5;
    if (this.jdField_a_of_type_Rmx == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: editColumn view is null!");
      return;
    }
    this.jdField_a_of_type_Rmx.c();
    this.jdField_a_of_type_Rmv.b(paramrml, new rne(this, paramrml));
  }
  
  public void a(@NotNull rml paramrml)
  {
    ColumnInfo localColumnInfo = new ColumnInfo(paramrml);
    this.jdField_a_of_type_Rmv.a(localColumnInfo);
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: saveColumnSketch column = " + paramrml.toString());
    }
  }
  
  public void a(rmx paramrmx)
  {
    this.jdField_a_of_type_Rmx = paramrmx;
  }
  
  public void a(@NotNull rqy paramrqy, @NotNull String paramString)
  {
    if (this.jdField_a_of_type_Rmx != null) {
      this.jdField_a_of_type_Rmx.a();
    }
    paramrqy.a(new rnc(this, paramString));
    paramrqy.a();
  }
  
  public int b()
  {
    return rha.e();
  }
  
  public void b()
  {
    ColumnInfo localColumnInfo = this.jdField_a_of_type_Rmv.a();
    if ((localColumnInfo != null) && (this.jdField_a_of_type_Rmx != null)) {
      this.jdField_a_of_type_Rmx.a(localColumnInfo);
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
  
  public void b(@NotNull rml paramrml)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: createColumn columnPublishInfo : " + paramrml.toString());
    }
    if (this.jdField_a_of_type_Rmx == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: createColumn view is null!");
      return;
    }
    paramrml = new ColumnInfo(paramrml);
    paramrml.source = 5;
    this.jdField_a_of_type_Rmx.c();
    this.jdField_a_of_type_Rmv.a(paramrml, new rnd(this, paramrml));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: clearColumnSketch.");
    }
    this.jdField_a_of_type_Rmv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnb
 * JD-Core Version:    0.7.0.1
 */