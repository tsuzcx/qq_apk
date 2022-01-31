import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ofd<D>
{
  public static int b;
  protected int a;
  protected VafContext a;
  protected final Map<String, Integer> a;
  protected int c = b + 1;
  protected int d = this.c;
  
  public ofd()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Int = 2147483647;
  }
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    int i = paramVafContext.getTemplateFactory().size();
    b = paramInt;
    this.c = (b + 1);
    this.d = this.c;
    if ((this.d < this.c + i) && (i > 0) && (this.d < this.jdField_a_of_type_Int))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      paramInt = this.d;
      paramVafContext = paramVafContext.iterator();
      if (paramVafContext.hasNext())
      {
        String str = (String)paramVafContext.next();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
          break label263;
        }
        this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(paramInt));
        paramInt += 1;
      }
    }
    label263:
    for (;;)
    {
      break;
      this.d = (this.c + i);
      if (this.jdField_a_of_type_Int == 2147483647) {
        this.jdField_a_of_type_Int = (this.d + 30);
      }
      if (this.d > this.jdField_a_of_type_Int) {
        this.d = this.jdField_a_of_type_Int;
      }
      QLog.d("DynamicItemViewHelperCompatBase", 1, "init: templateCount : " + i + " TYPE_DYNAMIC_END : " + this.d + " max : " + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == 2147483647) {
        this.jdField_a_of_type_Int = (this.c + 100);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= b) && (paramInt < this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofd
 * JD-Core Version:    0.7.0.1
 */