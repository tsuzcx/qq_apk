import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.mobileqq.utils.SecUtil;

class kxh
  implements axrt
{
  kxh(kxf paramkxf) {}
  
  public void onResp(axsq paramaxsq)
  {
    FilterItem localFilterItem = (FilterItem)paramaxsq.jdField_a_of_type_Axsp.a();
    if (paramaxsq.jdField_a_of_type_Int != 0) {
      krx.c("EffectFilterTools", "download IconFile. errcode = " + paramaxsq.b + "|" + localFilterItem.getId());
    }
    String str;
    do
    {
      return;
      str = SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c);
    } while (localFilterItem.getIconMd5().equalsIgnoreCase(str));
    krx.c("EffectFilterTools", "download IconFile faild : md5 is not match: " + localFilterItem.getIconMd5() + "|" + str);
    bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxh
 * JD-Core Version:    0.7.0.1
 */