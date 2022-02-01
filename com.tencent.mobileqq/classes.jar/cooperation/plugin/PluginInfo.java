package cooperation.plugin;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;

public class PluginInfo
  extends PluginBaseInfo
  implements Cloneable
{
  public static final String a = HardCodeUtil.a(2131906067);
  public static final String b = HardCodeUtil.a(2131906066);
  public static final String c = HardCodeUtil.a(2131906055);
  public static final String d = HardCodeUtil.a(2131906058);
  public static final String e = HardCodeUtil.a(2131906065);
  public static final String f = HardCodeUtil.a(2131906060);
  public static final String g = HardCodeUtil.a(2131906062);
  public static final String h = HardCodeUtil.a(2131906064);
  public static final String i = HardCodeUtil.a(2131906056);
  public static final String j = HardCodeUtil.a(2131906059);
  public static final String k = HardCodeUtil.a(2131906061);
  public static final String l = HardCodeUtil.a(2131906068);
  public static final String m = HardCodeUtil.a(2131906054);
  public static final String n = HardCodeUtil.a(2131906057);
  public static final String o = HardCodeUtil.a(2131906063);
  
  public PluginInfo a()
  {
    return (PluginInfo)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PluginInfo{mID='");
    localStringBuilder.append(this.mID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mName='");
    localStringBuilder.append(this.mName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVersion='");
    localStringBuilder.append(this.mVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mURL='");
    localStringBuilder.append(this.mURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMD5='");
    localStringBuilder.append(this.mMD5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLength=");
    localStringBuilder.append(this.mLength);
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(", mSubType=");
    localStringBuilder.append(this.mSubType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginInfo
 * JD-Core Version:    0.7.0.1
 */