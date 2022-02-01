import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;

class srk
  extends spi
{
  private boolean jdField_a_of_type_Boolean;
  
  private srk(sri paramsri, PTSItemView paramPTSItemView, BaseData paramBaseData)
  {
    super(paramPTSItemView, paramBaseData);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = sri.a(this.jdField_a_of_type_Sri, paramBaseData2);
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView instanceof PTSItemView))) {
      ((ProteusItemData)paramBaseData2).a.layoutToView((PTSItemView)this.jdField_a_of_type_AndroidViewView, sri.a(this.jdField_a_of_type_Sri), true);
    }
    this.jdField_a_of_type_Boolean = true;
    sri.a(this.jdField_a_of_type_Sri, paramBaseData1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srk
 * JD-Core Version:    0.7.0.1
 */