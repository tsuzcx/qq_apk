package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import java.util.List;

class TroopFileManager$5
  extends TroopFileGetFileListObserver
{
  TroopFileManager$5(TroopFileManager paramTroopFileManager) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List<TroopFileInfo> paramList, Bundle paramBundle)
  {
    ThreadManager.post(new TroopFileManager.5.1(this, paramBundle, paramInt2, paramByteStringMicro, paramBoolean1, paramList, paramBoolean2, paramInt3, paramInt1), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5
 * JD-Core Version:    0.7.0.1
 */