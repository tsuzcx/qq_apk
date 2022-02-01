package dov.com.qq.im.capture;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class EditState
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.EditState
 * JD-Core Version:    0.7.0.1
 */