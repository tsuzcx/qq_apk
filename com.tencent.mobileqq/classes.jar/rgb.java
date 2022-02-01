import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class rgb
  implements rfw
{
  private rfv jdField_a_of_type_Rfv;
  private rfx jdField_a_of_type_Rfx;
  
  public rgb(rfv paramrfv)
  {
    this.jdField_a_of_type_Rfv = paramrfv;
  }
  
  public int a()
  {
    return rab.d();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rfx = null;
  }
  
  public void a(int paramInt, @NotNull rfl paramrfl)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic srcColumnInfo.columnId : " + paramInt);
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic columnPublishInfo : " + paramrfl.toString());
    }
    paramrfl = new ColumnInfo(paramrfl);
    paramrfl.columnID = paramInt;
    paramrfl.source = 5;
    if (this.jdField_a_of_type_Rfx == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: editColumn view is null!");
      return;
    }
    this.jdField_a_of_type_Rfx.c();
    this.jdField_a_of_type_Rfv.b(paramrfl, new rge(this, paramrfl));
  }
  
  public void a(@NotNull rfl paramrfl)
  {
    ColumnInfo localColumnInfo = new ColumnInfo(paramrfl);
    this.jdField_a_of_type_Rfv.a(localColumnInfo);
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: saveColumnSketch column = " + paramrfl.toString());
    }
  }
  
  public void a(rfx paramrfx)
  {
    this.jdField_a_of_type_Rfx = paramrfx;
  }
  
  public void a(@NotNull rjy paramrjy, @NotNull String paramString)
  {
    if (this.jdField_a_of_type_Rfx != null) {
      this.jdField_a_of_type_Rfx.a();
    }
    paramrjy.a(new rgc(this, paramString));
    paramrjy.a();
  }
  
  public int b()
  {
    return rab.e();
  }
  
  public void b()
  {
    ColumnInfo localColumnInfo = this.jdField_a_of_type_Rfv.a();
    if ((localColumnInfo != null) && (this.jdField_a_of_type_Rfx != null)) {
      this.jdField_a_of_type_Rfx.a(localColumnInfo);
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
  
  public void b(@NotNull rfl paramrfl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: createColumn columnPublishInfo : " + paramrfl.toString());
    }
    if (this.jdField_a_of_type_Rfx == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: createColumn view is null!");
      return;
    }
    paramrfl = new ColumnInfo(paramrfl);
    paramrfl.source = 5;
    this.jdField_a_of_type_Rfx.c();
    this.jdField_a_of_type_Rfv.a(paramrfl, new rgd(this, paramrfl));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: clearColumnSketch.");
    }
    this.jdField_a_of_type_Rfv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgb
 * JD-Core Version:    0.7.0.1
 */