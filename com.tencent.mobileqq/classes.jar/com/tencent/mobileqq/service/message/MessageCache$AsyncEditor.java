package com.tencent.mobileqq.service.message;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MessageCache$AsyncEditor
  implements SharedPreferences.Editor
{
  private SharedPreferences.Editor b;
  private boolean c = false;
  
  public MessageCache$AsyncEditor(MessageCache paramMessageCache) {}
  
  private void a()
  {
    this.b = MessageCache.b(this.a).edit();
    if ((MessageCache.a(this.a) != null) && (MessageCache.a(this.a).size() > 0))
    {
      Iterator localIterator = MessageCache.a(this.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = MessageCache.a(this.a).get(str);
        if ((localObject instanceof Long)) {
          this.b.putLong(str, ((Long)localObject).longValue());
        } else if ((localObject instanceof String)) {
          this.b.putString(str, (String)localObject);
        } else if ((localObject instanceof Boolean)) {
          this.b.putBoolean(str, ((Boolean)localObject).booleanValue());
        } else if ((localObject instanceof Integer)) {
          this.b.putInt(str, ((Integer)localObject).intValue());
        } else if ((localObject instanceof Float)) {
          this.b.putFloat(str, ((Float)localObject).floatValue());
        }
      }
    }
  }
  
  @TargetApi(9)
  public void apply()
  {
    if (this.c)
    {
      this.c = false;
      if (Build.VERSION.SDK_INT < 9) {
        try
        {
          a();
          if (this.b.commit())
          {
            MessageCache.a(this.a).clear();
            return;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(MessageCache.I(), 2, "AsyncEditor commit fail!");
          return;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.w(MessageCache.I(), 2, "commit Exception ! ", localException);
          }
          this.c = true;
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.w(MessageCache.I(), 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
          }
          this.c = true;
          return;
        }
      } else {
        this.b.apply();
      }
    }
  }
  
  public SharedPreferences.Editor clear()
  {
    this.c = true;
    MessageCache.a(this.a).clear();
    return this;
  }
  
  public boolean commit()
  {
    if (this.c)
    {
      this.c = false;
      try
      {
        a();
        boolean bool = this.b.commit();
        if (bool)
        {
          MessageCache.a(this.a).clear();
          return bool;
        }
        if (QLog.isColorLevel()) {
          QLog.d(MessageCache.I(), 2, "AsyncEditor commit fail!");
        }
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(MessageCache.I(), 2, "commit Exception ! ", localException);
        }
        this.c = true;
        return false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.w(MessageCache.I(), 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
        }
        this.c = true;
      }
    }
    return false;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.c = true;
    MessageCache.a(this.a).put(paramString, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.c = true;
    MessageCache.a(this.a).put(paramString, Float.valueOf(paramFloat));
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.c = true;
    MessageCache.a(this.a).put(paramString, Integer.valueOf(paramInt));
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.c = true;
    MessageCache.a(this.a).put(paramString, Long.valueOf(paramLong));
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.c = true;
    MessageCache.a(this.a).put(paramString1, paramString2);
    return this;
  }
  
  @Deprecated
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.c = true;
    MessageCache.a(this.a).remove(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache.AsyncEditor
 * JD-Core Version:    0.7.0.1
 */