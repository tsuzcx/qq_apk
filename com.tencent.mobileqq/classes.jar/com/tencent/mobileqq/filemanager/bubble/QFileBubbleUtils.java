package com.tencent.mobileqq.filemanager.bubble;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkSupportBubbleMenu", "", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "checkSupportBubbleMenuWithSendPc", "contactUin", "", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
@JvmName(name="QFileBubbleUtils")
public final class QFileBubbleUtils
{
  public static final boolean a(@NotNull FileManagerEntity paramFileManagerEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramFileManagerEntity, "$this$checkSupportBubbleMenu");
    int i;
    switch (paramFileManagerEntity.getCloudType())
    {
    default: 
      i = 1;
      switch (paramFileManagerEntity.status)
      {
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label87;
      }
      return true;
      i = 0;
      break;
      i = 0;
      break;
    }
    label87:
    return false;
  }
  
  public static final boolean a(@NotNull FileManagerEntity paramFileManagerEntity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFileManagerEntity, "$this$checkSupportBubbleMenuWithSendPc");
    Intrinsics.checkParameterIsNotNull(paramString, "contactUin");
    boolean bool = a(paramFileManagerEntity);
    int i;
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    default: 
      i = 1;
      if (QFileAssistantUtils.a(paramString)) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      if ((!bool) || (i == 0) || (j == 0)) {
        break label89;
      }
      return true;
      i = 0;
      break;
      i = 0;
      break;
    }
    label89:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.QFileBubbleUtils
 * JD-Core Version:    0.7.0.1
 */