import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tcy
  extends ten
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((uac)sqg.a(7)).a(this.a);
    txz localtxz = (txz)sqg.a(24);
    txr localtxr = localtxz.a(localShareGroupItem.headerUnionIdList);
    if (localtxr == null)
    {
      localtxz.a(localShareGroupItem.headerUnionIdList, new tcz(this));
      return;
    }
    a(localtxr);
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarJob", 2, paramError, new Object[0]);
    }
    b(false);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarJob_sgi"))) {
      this.a = ((String)a("ShareGroupAvatarJob_sgi"));
    }
  }
  
  protected void a(txr paramtxr)
  {
    a("ShareGroupAvatarJob_sga", paramtxr.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcy
 * JD-Core Version:    0.7.0.1
 */