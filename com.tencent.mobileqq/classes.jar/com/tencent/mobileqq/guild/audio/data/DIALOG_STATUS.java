package com.tencent.mobileqq.guild.audio.data;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/data/DIALOG_STATUS;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "OPEN", "HIDE", "REOPEN", "DISMISS", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public enum DIALOG_STATUS
{
  static
  {
    DIALOG_STATUS localDIALOG_STATUS1 = new DIALOG_STATUS("UNKNOWN", 0);
    UNKNOWN = localDIALOG_STATUS1;
    DIALOG_STATUS localDIALOG_STATUS2 = new DIALOG_STATUS("OPEN", 1);
    OPEN = localDIALOG_STATUS2;
    DIALOG_STATUS localDIALOG_STATUS3 = new DIALOG_STATUS("HIDE", 2);
    HIDE = localDIALOG_STATUS3;
    DIALOG_STATUS localDIALOG_STATUS4 = new DIALOG_STATUS("REOPEN", 3);
    REOPEN = localDIALOG_STATUS4;
    DIALOG_STATUS localDIALOG_STATUS5 = new DIALOG_STATUS("DISMISS", 4);
    DISMISS = localDIALOG_STATUS5;
    $VALUES = new DIALOG_STATUS[] { localDIALOG_STATUS1, localDIALOG_STATUS2, localDIALOG_STATUS3, localDIALOG_STATUS4, localDIALOG_STATUS5 };
  }
  
  private DIALOG_STATUS() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS
 * JD-Core Version:    0.7.0.1
 */