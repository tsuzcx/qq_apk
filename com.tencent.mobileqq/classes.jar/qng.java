import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;

public class qng
{
  public String a;
  
  public static List<qng> a(oidb_cmd0xbc9.DynamicBannerItem paramDynamicBannerItem)
  {
    localArrayList = new ArrayList();
    if (!paramDynamicBannerItem.bytes_dynamic_json.has()) {}
    for (;;)
    {
      return localArrayList;
      Object localObject = paramDynamicBannerItem.bytes_dynamic_json.get().toStringUtf8();
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        int i = 0;
        while (i < localJSONArray.length())
        {
          qng localqng = new qng();
          localqng.a = localJSONArray.get(i).toString();
          localArrayList.add(localqng);
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception localException)
      {
        QLog.d("TopBannerInfo", 4, "" + (String)localObject);
        localObject = new qng();
        ((qng)localObject).a = paramDynamicBannerItem.bytes_dynamic_json.get().toStringUtf8();
        localArrayList.add(localObject);
      }
    }
  }
  
  public oidb_cmd0xbc9.DynamicBannerItem a()
  {
    oidb_cmd0xbc9.DynamicBannerItem localDynamicBannerItem = new oidb_cmd0xbc9.DynamicBannerItem();
    if (!TextUtils.isEmpty(this.a)) {
      localDynamicBannerItem.bytes_dynamic_json.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    return localDynamicBannerItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qng
 * JD-Core Version:    0.7.0.1
 */