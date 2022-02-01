package com.tencent.mobileqq.config.business.qflutter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "ExpandPluginPreload", "ExpandPluginPreInstall", "ExpandPluginPreDownload", "QFlutterEngine", "Unknown", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum ExpandModuleKey
{
  public static final ExpandModuleKey.Companion Companion = new ExpandModuleKey.Companion(null);
  @NotNull
  private final String desc;
  
  static
  {
    ExpandModuleKey localExpandModuleKey1 = new ExpandModuleKey("ExpandPluginPreload", 0, "ExpandPluginPreload");
    ExpandPluginPreload = localExpandModuleKey1;
    ExpandModuleKey localExpandModuleKey2 = new ExpandModuleKey("ExpandPluginPreInstall", 1, "ExpandPluginPreInstall");
    ExpandPluginPreInstall = localExpandModuleKey2;
    ExpandModuleKey localExpandModuleKey3 = new ExpandModuleKey("ExpandPluginPreDownload", 2, "ExpandPluginPreDownload");
    ExpandPluginPreDownload = localExpandModuleKey3;
    ExpandModuleKey localExpandModuleKey4 = new ExpandModuleKey("QFlutterEngine", 3, "QFlutterEngine");
    QFlutterEngine = localExpandModuleKey4;
    ExpandModuleKey localExpandModuleKey5 = new ExpandModuleKey("Unknown", 4, "Unknown");
    Unknown = localExpandModuleKey5;
    $VALUES = new ExpandModuleKey[] { localExpandModuleKey1, localExpandModuleKey2, localExpandModuleKey3, localExpandModuleKey4, localExpandModuleKey5 };
  }
  
  private ExpandModuleKey(String paramString)
  {
    this.desc = paramString;
  }
  
  @NotNull
  public final String getDesc()
  {
    return this.desc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey
 * JD-Core Version:    0.7.0.1
 */