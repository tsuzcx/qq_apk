package com.tencent.qapmsdk.socket.handler;

import android.text.TextUtils;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.model.Utf8Checker;
import java.io.ByteArrayOutputStream;

class TrafficIOStreamHandlerManager$Body
  extends TrafficIOStreamHandlerManager.Data
{
  private static final String TAG = "QAPM_Socket_Body";
  ByteArrayOutputStream chunkBaos = new ByteArrayOutputStream();
  long chunkRemain;
  long remain;
  int size = 0;
  Utf8Checker utf8Checker = new Utf8Checker();
  
  TrafficIOStreamHandlerManager$Body(boolean paramBoolean, SocketInfo paramSocketInfo)
  {
    super(paramBoolean, paramSocketInfo);
  }
  
  void parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.socketInfo.chunked) {
      this.chunkBaos.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    label173:
    do
    {
      paramArrayOfByte = this.chunkBaos.toByteArray();
      for (;;)
      {
        Object localObject;
        if (this.offset < paramArrayOfByte.length)
        {
          if (this.chunkRemain == 0L)
          {
            localObject = readLine(paramArrayOfByte);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              long l = 0L;
              localObject = localObject.split(";")[0];
              paramInt2 = 0;
              if (paramInt2 < ((String)localObject).length())
              {
                paramInt1 = localObject.getBytes()[paramInt2];
                if ((paramInt1 >= 48) && (paramInt1 <= 57)) {
                  paramInt1 -= 48;
                }
                for (;;)
                {
                  l = l << 4 | paramInt1;
                  paramInt2 += 1;
                  break;
                  if ((paramInt1 >= 97) && (paramInt1 <= 102))
                  {
                    paramInt1 = paramInt1 - 97 + 10;
                  }
                  else
                  {
                    if ((paramInt1 < 65) || (paramInt1 > 70)) {
                      break label173;
                    }
                    paramInt1 = paramInt1 - 65 + 10;
                  }
                }
              }
              if (l == 0L) {
                this.isCompleted = true;
              }
              this.chunkRemain = l;
            }
          }
          if (!this.isCompleted) {}
        }
        else
        {
          return;
        }
        if (this.chunkRemain != 0L)
        {
          localObject = readBytes(paramArrayOfByte, (int)this.chunkRemain);
          this.size += localObject.length;
          this.chunkRemain -= localObject.length;
        }
      }
      this.size += paramInt2;
      this.remain -= paramInt2;
    } while (this.remain != 0L);
    this.isCompleted = true;
  }
  
  byte[] toByteArray()
  {
    return this.baos.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.Body
 * JD-Core Version:    0.7.0.1
 */