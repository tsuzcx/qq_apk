import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;

class svi
  extends stg
{
  private boolean jdField_a_of_type_Boolean;
  
  private svi(svg paramsvg, PTSItemView paramPTSItemView, BaseData paramBaseData)
  {
    super(paramPTSItemView, paramBaseData);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = svg.a(this.jdField_a_of_type_Svg, paramBaseData2);
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView instanceof PTSItemView))) {
      ((ProteusItemData)paramBaseData2).a.layoutToView((PTSItemView)this.jdField_a_of_type_AndroidViewView, svg.a(this.jdField_a_of_type_Svg), true);
    }
    this.jdField_a_of_type_Boolean = true;
    svg.a(this.jdField_a_of_type_Svg, paramBaseData1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svi
 * JD-Core Version:    0.7.0.1
 */