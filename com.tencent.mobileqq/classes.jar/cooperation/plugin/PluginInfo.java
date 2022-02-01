package cooperation.plugin;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;

public class PluginInfo
  extends PluginBaseInfo
  implements Cloneable
{
  public static final String a = HardCodeUtil.a(2131708264);
  public static final String b = HardCodeUtil.a(2131708263);
  public static final String c = HardCodeUtil.a(2131708252);
  public static final String d = HardCodeUtil.a(2131708255);
  public static final String e = HardCodeUtil.a(2131708262);
  public static final String f = HardCodeUtil.a(2131708257);
  public static final String g = HardCodeUtil.a(2131708259);
  public static final String h = HardCodeUtil.a(2131708261);
  public static final String i = HardCodeUtil.a(2131708253);
  public static final String j = HardCodeUtil.a(2131708256);
  public static final String k = HardCodeUtil.a(2131708258);
  public static final String l = HardCodeUtil.a(2131708265);
  public static final String m = HardCodeUtil.a(2131708251);
  public static final String n = HardCodeUtil.a(2131708254);
  public static final String o = HardCodeUtil.a(2131708260);
  int a;
  
  public PluginInfo a()
  {
    return (PluginInfo)super.clone();
  }
  
  public String toString()
  {
    return "PluginInfo{mID='" + this.mID + '\'' + ", mName='" + this.mName + '\'' + ", mVersion='" + this.mVersion + '\'' + ", mURL='" + this.mURL + '\'' + ", mMD5='" + this.mMD5 + '\'' + ", mLength=" + this.mLength + ", mType=" + this.mType + ", mSubType=" + this.mSubType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginInfo
 * JD-Core Version:    0.7.0.1
 */