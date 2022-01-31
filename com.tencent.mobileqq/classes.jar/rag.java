import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rag
{
  public static HashMap<Integer, Long> a = new HashMap();
  public static HashMap<Integer, ArrayList<rah>> b = new HashMap();
  
  public static JSONArray a()
  {
    try
    {
      a();
      JSONArray localJSONArray1 = new JSONArray();
      Iterator localIterator = b.keySet().iterator();
      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
      localNumberFormat.setMaximumFractionDigits(2);
      localNumberFormat.setMinimumFractionDigits(2);
      localNumberFormat.setRoundingMode(RoundingMode.HALF_UP);
      localNumberFormat.setGroupingUsed(false);
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        localObject = ((ArrayList)b.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          rah localrah = (rah)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("downloadTime", new Float(localNumberFormat.format(Math.round(localrah.jdField_a_of_type_Float * 100.0F) / 100.0F)));
            localJSONObject.put("speedList", localrah.b);
            localJSONArray1.put(localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return localJSONArray2;
  }
  
  public static void a()
  {
    Iterator localIterator = a.keySet().iterator();
    long l = System.currentTimeMillis();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((Long)a.get(localInteger)).longValue() < l - 60000L)
      {
        b.remove(localInteger);
        localIterator.remove();
      }
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    for (;;)
    {
      long l;
      try
      {
        l = System.currentTimeMillis();
        a.put(Integer.valueOf(paramInt), Long.valueOf(l));
        if (b.get(Integer.valueOf(paramInt)) != null)
        {
          ArrayList localArrayList1 = (ArrayList)b.get(Integer.valueOf(paramInt));
          localrah1 = (rah)localArrayList1.get(0);
          rah localrah2 = new rah();
          localrah2.b = paramLong;
          localrah2.jdField_a_of_type_Long = l;
          localrah2.jdField_a_of_type_Float = ((float)(l - localrah1.jdField_a_of_type_Long) / 1000.0F);
          localArrayList1.add(localrah2);
          b.put(Integer.valueOf(paramInt), localArrayList1);
          a();
          return;
        }
      }
      finally {}
      ArrayList localArrayList2 = new ArrayList();
      rah localrah1 = new rah();
      localrah1.b = paramLong;
      localrah1.jdField_a_of_type_Long = l;
      localrah1.jdField_a_of_type_Float = 0.0F;
      localArrayList2.add(localrah1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rag
 * JD-Core Version:    0.7.0.1
 */