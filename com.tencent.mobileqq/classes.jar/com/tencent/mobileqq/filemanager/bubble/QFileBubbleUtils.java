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
    int i = paramFileManagerEntity.getCloudType();
    if ((i != 0) && (i != 11)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramFileManagerEntity.status != 16) {
      j = 1;
    } else {
      j = 0;
    }
    return (i != 0) && (j != 0);
  }
  
  public static final boolean a(@NotNull FileManagerEntity paramFileManagerEntity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFileManagerEntity, "$this$checkSupportBubbleMenuWithSendPc");
    Intrinsics.checkParameterIsNotNull(paramString, "contactUin");
    boolean bool3 = a(paramFileManagerEntity);
    int i = paramFileManagerEntity.status;
    boolean bool2 = false;
    if ((i != 0) && (i != 2)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool4 = QFileAssistantUtils.a(paramString);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if ((bool4 ^ true)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.QFileBubbleUtils
 * JD-Core Version:    0.7.0.1
 */