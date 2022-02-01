package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/InputPanelConfig;", "Ljava/io/Serializable;", "showPicPanel", "", "showVideoPanel", "showEmotionLPanel", "showAtPanel", "showTopicPanel", "showCommodity", "showInvitedManuscript", "showSubmitManuscript", "(ZZZZZZZZ)V", "getShowAtPanel", "()Z", "setShowAtPanel", "(Z)V", "getShowCommodity", "setShowCommodity", "getShowEmotionLPanel", "setShowEmotionLPanel", "getShowInvitedManuscript", "setShowInvitedManuscript", "getShowPicPanel", "setShowPicPanel", "getShowSubmitManuscript", "setShowSubmitManuscript", "getShowTopicPanel", "setShowTopicPanel", "getShowVideoPanel", "setShowVideoPanel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class InputPanelConfig
  implements Serializable
{
  private boolean showAtPanel;
  private boolean showCommodity;
  private boolean showEmotionLPanel;
  private boolean showInvitedManuscript;
  private boolean showPicPanel;
  private boolean showSubmitManuscript;
  private boolean showTopicPanel;
  private boolean showVideoPanel;
  
  public InputPanelConfig()
  {
    this(false, false, false, false, false, false, false, false, 255, null);
  }
  
  public InputPanelConfig(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    this.showPicPanel = paramBoolean1;
    this.showVideoPanel = paramBoolean2;
    this.showEmotionLPanel = paramBoolean3;
    this.showAtPanel = paramBoolean4;
    this.showTopicPanel = paramBoolean5;
    this.showCommodity = paramBoolean6;
    this.showInvitedManuscript = paramBoolean7;
    this.showSubmitManuscript = paramBoolean8;
  }
  
  public final boolean component1()
  {
    return this.showPicPanel;
  }
  
  public final boolean component2()
  {
    return this.showVideoPanel;
  }
  
  public final boolean component3()
  {
    return this.showEmotionLPanel;
  }
  
  public final boolean component4()
  {
    return this.showAtPanel;
  }
  
  public final boolean component5()
  {
    return this.showTopicPanel;
  }
  
  public final boolean component6()
  {
    return this.showCommodity;
  }
  
  public final boolean component7()
  {
    return this.showInvitedManuscript;
  }
  
  public final boolean component8()
  {
    return this.showSubmitManuscript;
  }
  
  @NotNull
  public final InputPanelConfig copy(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    return new InputPanelConfig(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramBoolean8);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof InputPanelConfig))
      {
        paramObject = (InputPanelConfig)paramObject;
        if ((this.showPicPanel == paramObject.showPicPanel) && (this.showVideoPanel == paramObject.showVideoPanel) && (this.showEmotionLPanel == paramObject.showEmotionLPanel) && (this.showAtPanel == paramObject.showAtPanel) && (this.showTopicPanel == paramObject.showTopicPanel) && (this.showCommodity == paramObject.showCommodity) && (this.showInvitedManuscript == paramObject.showInvitedManuscript) && (this.showSubmitManuscript == paramObject.showSubmitManuscript)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getShowAtPanel()
  {
    return this.showAtPanel;
  }
  
  public final boolean getShowCommodity()
  {
    return this.showCommodity;
  }
  
  public final boolean getShowEmotionLPanel()
  {
    return this.showEmotionLPanel;
  }
  
  public final boolean getShowInvitedManuscript()
  {
    return this.showInvitedManuscript;
  }
  
  public final boolean getShowPicPanel()
  {
    return this.showPicPanel;
  }
  
  public final boolean getShowSubmitManuscript()
  {
    return this.showSubmitManuscript;
  }
  
  public final boolean getShowTopicPanel()
  {
    return this.showTopicPanel;
  }
  
  public final boolean getShowVideoPanel()
  {
    return this.showVideoPanel;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setShowAtPanel(boolean paramBoolean)
  {
    this.showAtPanel = paramBoolean;
  }
  
  public final void setShowCommodity(boolean paramBoolean)
  {
    this.showCommodity = paramBoolean;
  }
  
  public final void setShowEmotionLPanel(boolean paramBoolean)
  {
    this.showEmotionLPanel = paramBoolean;
  }
  
  public final void setShowInvitedManuscript(boolean paramBoolean)
  {
    this.showInvitedManuscript = paramBoolean;
  }
  
  public final void setShowPicPanel(boolean paramBoolean)
  {
    this.showPicPanel = paramBoolean;
  }
  
  public final void setShowSubmitManuscript(boolean paramBoolean)
  {
    this.showSubmitManuscript = paramBoolean;
  }
  
  public final void setShowTopicPanel(boolean paramBoolean)
  {
    this.showTopicPanel = paramBoolean;
  }
  
  public final void setShowVideoPanel(boolean paramBoolean)
  {
    this.showVideoPanel = paramBoolean;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InputPanelConfig(showPicPanel=");
    localStringBuilder.append(this.showPicPanel);
    localStringBuilder.append(", showVideoPanel=");
    localStringBuilder.append(this.showVideoPanel);
    localStringBuilder.append(", showEmotionLPanel=");
    localStringBuilder.append(this.showEmotionLPanel);
    localStringBuilder.append(", showAtPanel=");
    localStringBuilder.append(this.showAtPanel);
    localStringBuilder.append(", showTopicPanel=");
    localStringBuilder.append(this.showTopicPanel);
    localStringBuilder.append(", showCommodity=");
    localStringBuilder.append(this.showCommodity);
    localStringBuilder.append(", showInvitedManuscript=");
    localStringBuilder.append(this.showInvitedManuscript);
    localStringBuilder.append(", showSubmitManuscript=");
    localStringBuilder.append(this.showSubmitManuscript);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.InputPanelConfig
 * JD-Core Version:    0.7.0.1
 */