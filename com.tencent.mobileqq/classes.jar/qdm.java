import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;

public class qdm
{
  public final int a;
  public long a;
  public String a;
  public List<qdl> a;
  public boolean a;
  public String b;
  public List<qdl> b;
  public String c;
  public String d;
  public String e;
  
  public qdm(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static qdm a(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    qdm localqdm = null;
    if (paramBannerItem.uint32_banner_type.has())
    {
      if (paramBannerItem.uint32_banner_type.get() == 2) {
        localqdm = qdq.b(paramBannerItem);
      }
    }
    else {
      return localqdm;
    }
    return qdo.b(paramBannerItem);
  }
  
  protected static void a(qdm paramqdm, oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    boolean bool = true;
    if (paramqdm != null)
    {
      if (paramBannerItem.uint32_is_ad.get() == 1) {}
      Object localObject;
      for (;;)
      {
        paramqdm.jdField_a_of_type_Boolean = bool;
        paramqdm.jdField_a_of_type_Long = paramBannerItem.uint64_banner_id.get();
        localObject = paramBannerItem.msg_ad_click_report.get();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        paramqdm.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          oidb_cmd0xbc9.AdReport localAdReport = (oidb_cmd0xbc9.AdReport)((Iterator)localObject).next();
          paramqdm.jdField_a_of_type_JavaUtilList.add(qdl.a(localAdReport));
        }
        bool = false;
      }
      paramBannerItem = paramBannerItem.msg_ad_exposure_report.get();
      if ((paramBannerItem != null) && (paramBannerItem.size() > 0))
      {
        paramqdm.jdField_b_of_type_JavaUtilList = new ArrayList();
        paramBannerItem = paramBannerItem.iterator();
        while (paramBannerItem.hasNext())
        {
          localObject = (oidb_cmd0xbc9.AdReport)paramBannerItem.next();
          paramqdm.jdField_b_of_type_JavaUtilList.add(qdl.a((oidb_cmd0xbc9.AdReport)localObject));
        }
      }
    }
  }
  
  public static void a(oidb_cmd0xbc9.BannerItem paramBannerItem, qdm paramqdm)
  {
    if (paramBannerItem.bytes_superscript_color.has()) {
      paramqdm.jdField_a_of_type_JavaLangString = paramBannerItem.bytes_superscript_color.get().toStringUtf8();
    }
    if (paramBannerItem.bytes_superscript_text.has()) {
      paramqdm.jdField_b_of_type_JavaLangString = paramBannerItem.bytes_superscript_text.get().toStringUtf8();
    }
    if (paramBannerItem.bytes_banner_title.has()) {
      paramqdm.d = paramBannerItem.bytes_banner_title.get().toStringUtf8();
    }
  }
  
  public List<String> a(List<qdl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((qdl)paramList.next()).jdField_a_of_type_JavaLangString);
    }
    return localArrayList;
  }
  
  public oidb_cmd0xbc9.BannerItem a()
  {
    oidb_cmd0xbc9.BannerItem localBannerItem = new oidb_cmd0xbc9.BannerItem();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localBannerItem.bytes_superscript_text.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localBannerItem.bytes_superscript_color.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localBannerItem.bytes_banner_title.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    localBannerItem.uint32_banner_type.set(this.jdField_a_of_type_Int);
    a(localBannerItem);
    return localBannerItem;
  }
  
  protected void a(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    Object localObject = paramBannerItem.uint32_is_ad;
    if (this.jdField_a_of_type_Boolean) {}
    Iterator localIterator;
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      paramBannerItem.uint64_banner_id.set(this.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label114;
      }
      localObject = new ArrayList();
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((qdl)localIterator.next()).a());
      }
    }
    paramBannerItem.msg_ad_click_report.addAll((Collection)localObject);
    label114:
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject = new ArrayList();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((qdl)localIterator.next()).a());
      }
      paramBannerItem.msg_ad_exposure_report.addAll((Collection)localObject);
    }
  }
  
  public String toString()
  {
    return "rowkey:" + this.e + " title:" + this.d + "tagText:" + this.jdField_b_of_type_JavaLangString + "tagColor:" + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdm
 * JD-Core Version:    0.7.0.1
 */