package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class StructMsgItemCover$DownLoad
  extends AsyncTask<String, Integer, Boolean>
{
  Bitmap a;
  ImageView b;
  Context c;
  
  protected Boolean a(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new URL(paramVarArgs[0]);
    }
    catch (Exception paramVarArgs)
    {
      label64:
      label69:
      label74:
      break label74;
    }
    try
    {
      paramVarArgs = (HttpURLConnection)paramVarArgs.openConnection();
      paramVarArgs.setDoInput(true);
      paramVarArgs.setConnectTimeout(30000);
      paramVarArgs.setReadTimeout(30000);
      paramVarArgs.connect();
      paramVarArgs = paramVarArgs.getInputStream();
      this.a = BitmapFactory.decodeStream(paramVarArgs);
      paramVarArgs.close();
      return Boolean.valueOf(true);
    }
    catch (Exception paramVarArgs)
    {
      break label69;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      break label64;
    }
    return Boolean.valueOf(false);
    return Boolean.valueOf(false);
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = StructMsgItemCover.a(new BitmapDrawable(this.c.getResources(), this.a));
      if (paramBoolean != null) {
        this.b.setImageBitmap(paramBoolean);
      }
    }
  }
  
  protected void onCancelled() {}
  
  protected void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover.DownLoad
 * JD-Core Version:    0.7.0.1
 */