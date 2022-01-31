import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONObject;

class stj
  extends SimpleJob<Object>
{
  stj(sti paramsti, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    Object localObject = (String)((tcv)tdc.a(10)).b("SP_KEY_AUTHKEY_SERVER_INFO", "");
    synchronized (this.a.b)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = this.a.a.jdField_a_of_type_Long;
        if (l != 0L) {}
      }
      try
      {
        paramVarArgs = new stm();
        localObject = new JSONObject((String)localObject);
        paramVarArgs.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("t");
        paramVarArgs.jdField_a_of_type_ArrayOfByte = bbdm.a(((JSONObject)localObject).getString("ak"));
        this.a.a = paramVarArgs;
        veg.a("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init success -> %s", localObject);
        return null;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          veg.b("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init error , %s", paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stj
 * JD-Core Version:    0.7.0.1
 */