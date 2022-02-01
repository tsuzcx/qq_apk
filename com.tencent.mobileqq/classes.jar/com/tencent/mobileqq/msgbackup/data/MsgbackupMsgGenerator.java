package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/msgbackup/data/MsgbackupMsgGenerator;", "", "()V", "generateUserData", "Lcom/tencent/mobileqq/msgbackup/data/MsgBackupMsgUserData;", "friendUin", "", "uintype", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MsgbackupMsgGenerator
{
  @JvmField
  @Nullable
  public static String a;
  public static final MsgbackupMsgGenerator.Companion b = new MsgbackupMsgGenerator.Companion(null);
  private static final Random c = new Random();
  
  @JvmStatic
  @NotNull
  public static final List<MessageRecord> a(@Nullable String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2, @Nullable String paramString3)
  {
    return b.a(paramString1, paramInt1, paramString2, paramInt2, paramString3);
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface)
  {
    b.a(paramQQAppInterface);
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @Nullable List<? extends MessageRecord> paramList)
  {
    b.a(paramQQAppInterface, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgbackupMsgGenerator
 * JD-Core Version:    0.7.0.1
 */