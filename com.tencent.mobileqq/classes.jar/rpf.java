import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class rpf
  implements rpa
{
  private roz jdField_a_of_type_Roz;
  private rpb jdField_a_of_type_Rpb;
  
  public rpf(roz paramroz)
  {
    this.jdField_a_of_type_Roz = paramroz;
  }
  
  public int a()
  {
    return rjh.b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rpb = null;
  }
  
  public void a(int paramInt, @NotNull rop paramrop)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic srcColumnInfo.columnId : " + paramInt);
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic columnPublishInfo : " + paramrop.toString());
    }
    paramrop = new ColumnInfo(paramrop);
    paramrop.columnID = paramInt;
    paramrop.source = 5;
    if (this.jdField_a_of_type_Rpb == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: editColumn view is null!");
      return;
    }
    this.jdField_a_of_type_Rpb.c();
    this.jdField_a_of_type_Roz.b(paramrop, new rpi(this, paramrop));
  }
  
  public void a(@NotNull rop paramrop)
  {
    ColumnInfo localColumnInfo = new ColumnInfo(paramrop);
    this.jdField_a_of_type_Roz.a(localColumnInfo);
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: saveColumnSketch column = " + paramrop.toString());
    }
  }
  
  public void a(rpb paramrpb)
  {
    this.jdField_a_of_type_Rpb = paramrpb;
  }
  
  public void a(@NotNull rtc paramrtc, @NotNull String paramString)
  {
    if (this.jdField_a_of_type_Rpb != null) {
      this.jdField_a_of_type_Rpb.a();
    }
    paramrtc.a(new rpg(this, paramString));
    paramrtc.a();
  }
  
  public int b()
  {
    return rjh.c();
  }
  
  public void b()
  {
    ColumnInfo localColumnInfo = this.jdField_a_of_type_Roz.a();
    if ((localColumnInfo != null) && (this.jdField_a_of_type_Rpb != null)) {
      this.jdField_a_of_type_Rpb.a(localColumnInfo);
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
  
  public void b(@NotNull rop paramrop)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: createColumn columnPublishInfo : " + paramrop.toString());
    }
    if (this.jdField_a_of_type_Rpb == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: createColumn view is null!");
      return;
    }
    paramrop = new ColumnInfo(paramrop);
    paramrop.source = 5;
    this.jdField_a_of_type_Rpb.c();
    this.jdField_a_of_type_Roz.a(paramrop, new rph(this, paramrop));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: clearColumnSketch.");
    }
    this.jdField_a_of_type_Roz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpf
 * JD-Core Version:    0.7.0.1
 */