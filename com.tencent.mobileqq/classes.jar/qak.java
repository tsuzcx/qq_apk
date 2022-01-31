import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;

public class qak
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public static qak a(articlesummary.ArkAppFeedsInfo paramArkAppFeedsInfo)
  {
    if (paramArkAppFeedsInfo == null)
    {
      QLog.d("ArkAppFeedsInfo", 1, "covertPBToInfo feedsInfo == null");
      return null;
    }
    qak localqak = new qak();
    long l;
    int i;
    label65:
    String str;
    if (paramArkAppFeedsInfo.uint64_feeds_id.has())
    {
      l = paramArkAppFeedsInfo.uint64_feeds_id.get();
      localqak.jdField_a_of_type_Long = l;
      if (!paramArkAppFeedsInfo.uint32_feeds_style.has()) {
        break label418;
      }
      i = paramArkAppFeedsInfo.uint32_feeds_style.get();
      localqak.jdField_a_of_type_Int = i;
      if ((!paramArkAppFeedsInfo.bytes_app_name.has()) || (paramArkAppFeedsInfo.bytes_app_name.get() == null)) {
        break label423;
      }
      str = paramArkAppFeedsInfo.bytes_app_name.get().toStringUtf8();
      label103:
      localqak.jdField_a_of_type_JavaLangString = str;
      if ((!paramArkAppFeedsInfo.bytes_app_view.has()) || (paramArkAppFeedsInfo.bytes_app_view.get() == null)) {
        break label430;
      }
      str = paramArkAppFeedsInfo.bytes_app_view.get().toStringUtf8();
      label142:
      localqak.b = str;
      if ((!paramArkAppFeedsInfo.bytes_app_desc.has()) || (paramArkAppFeedsInfo.bytes_app_desc.get() == null)) {
        break label437;
      }
      str = paramArkAppFeedsInfo.bytes_app_desc.get().toStringUtf8();
      label181:
      localqak.c = str;
      if ((!paramArkAppFeedsInfo.bytes_app_prompt.has()) || (paramArkAppFeedsInfo.bytes_app_prompt.get() == null)) {
        break label444;
      }
      str = paramArkAppFeedsInfo.bytes_app_prompt.get().toStringUtf8();
      label220:
      localqak.d = str;
      if ((!paramArkAppFeedsInfo.bytes_app_ver.has()) || (paramArkAppFeedsInfo.bytes_app_ver.get() == null)) {
        break label451;
      }
      str = paramArkAppFeedsInfo.bytes_app_ver.get().toStringUtf8();
      label259:
      localqak.e = str;
      if ((!paramArkAppFeedsInfo.bytes_app_meta.has()) || (paramArkAppFeedsInfo.bytes_app_meta.get() == null)) {
        break label458;
      }
    }
    label418:
    label423:
    label430:
    label437:
    label444:
    label451:
    label458:
    for (paramArkAppFeedsInfo = paramArkAppFeedsInfo.bytes_app_meta.get().toStringUtf8();; paramArkAppFeedsInfo = "")
    {
      localqak.f = paramArkAppFeedsInfo;
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppFeedsInfo", 2, new Object[] { "mFeedsId: ", Long.valueOf(localqak.jdField_a_of_type_Long), ", mFeedsStyle: ", Integer.valueOf(localqak.jdField_a_of_type_Int), ", appName: ", localqak.jdField_a_of_type_JavaLangString, ", appView: ", localqak.b, ", appMinVersion: ", localqak.e, ", metaList: ", localqak.f });
      }
      return localqak;
      l = 0L;
      break;
      i = 0;
      break label65;
      str = "";
      break label103;
      str = "";
      break label142;
      str = "";
      break label181;
      str = "";
      break label220;
      str = "";
      break label259;
    }
  }
  
  public qak a()
  {
    try
    {
      qak localqak = (qak)super.clone();
      return localqak;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppFeedsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
      }
    }
    return null;
  }
  
  public articlesummary.ArkAppFeedsInfo a()
  {
    articlesummary.ArkAppFeedsInfo localArkAppFeedsInfo = new articlesummary.ArkAppFeedsInfo();
    localArkAppFeedsInfo.uint32_feeds_style.set(this.jdField_a_of_type_Int);
    localArkAppFeedsInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localArkAppFeedsInfo.bytes_app_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localArkAppFeedsInfo.bytes_app_view.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localArkAppFeedsInfo.bytes_app_desc.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localArkAppFeedsInfo.bytes_app_prompt.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localArkAppFeedsInfo.bytes_app_ver.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localArkAppFeedsInfo.bytes_app_meta.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    return localArkAppFeedsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qak
 * JD-Core Version:    0.7.0.1
 */