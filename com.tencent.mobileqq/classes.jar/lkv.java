import android.content.Context;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodec.HWCodecAbility;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class lkv
  implements mwy
{
  private final Context a;
  
  public lkv(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public String a()
  {
    return AVSoUtils.c();
  }
  
  public void a() {}
  
  public String b()
  {
    return AVSoUtils.d();
  }
  
  public String c()
  {
    String str = "";
    Object localObject = AndroidCodec.checkSupportHWCodecAbility("AVSoProxyImpl", this.a);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      localObject = str;
      if (!localIterator.hasNext()) {
        break label540;
      }
      localObject = (AndroidCodec.HWCodecAbility)localIterator.next();
      if ((((AndroidCodec.HWCodecAbility)localObject).codecType == 1) && (((AndroidCodec.HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWAVCDEC=1;";
        str = str + "HWAVCDEC_MAXW=" + ((AndroidCodec.HWCodecAbility)localObject).maxW + ";";
        str = str + "HWAVCDEC_MAXH=" + ((AndroidCodec.HWCodecAbility)localObject).maxH + ";";
      }
    }
    for (;;)
    {
      break;
      if ((((AndroidCodec.HWCodecAbility)localObject).codecType == 2) && (((AndroidCodec.HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWAVCENC=1;";
        str = str + "HWAVCENC_MAXW=" + ((AndroidCodec.HWCodecAbility)localObject).maxW + ";";
        str = str + "HWAVCENC_MAXH=" + ((AndroidCodec.HWCodecAbility)localObject).maxH + ";";
      }
      else if ((((AndroidCodec.HWCodecAbility)localObject).codecType == 4) && (((AndroidCodec.HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWHEVCDEC=1;";
        str = str + "HWHEVCDEC_MAXW=" + ((AndroidCodec.HWCodecAbility)localObject).maxW + ";";
        str = str + "HWHEVCDEC_MAXH=" + ((AndroidCodec.HWCodecAbility)localObject).maxH + ";";
      }
      else if ((((AndroidCodec.HWCodecAbility)localObject).codecType == 8) && (((AndroidCodec.HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWHEVCENC=1;";
        str = str + "HWHEVCENC_MAXW=" + ((AndroidCodec.HWCodecAbility)localObject).maxW + ";";
        str = str + "HWHEVCENC_MAXH=" + ((AndroidCodec.HWCodecAbility)localObject).maxH + ";";
        continue;
        str = "" + "HWAVCENC=0;";
        str = str + "HWAVCDEC=0;";
        str = str + "HWHEVCENC=0;";
        localObject = str + "HWHEVCDEC=0;";
        label540:
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkv
 * JD-Core Version:    0.7.0.1
 */