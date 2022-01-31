import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class spf
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private spg jdField_a_of_type_Spg;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public spf()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      ved.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().a(Card.class, (String)localObject);
    if (localObject == null) {
      ved.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<sqw> a(@NonNull sph paramsph, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramsph.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool);
      if (paramsph.jdField_a_of_type_Int == 0) {
        break;
      }
      paramsph = new sqw(paramsph, paramsph.jdField_a_of_type_Int);
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramsph });
      localArrayList.add(paramsph);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      vxp.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      ved.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(vxy.c(1000L * l)).intValue();
      int j = Integer.valueOf(vxy.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        sqw localsqw = new sqw(paramsph, i);
        ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localsqw });
        localArrayList.add(localsqw);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<sqw> a(@NonNull sph paramsph, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramsph.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramsph.jdField_b_of_type_JavaLangString)))
    {
      vxp.a("init birthday rule failed:" + paramsph, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      vxp.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramsph, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      ved.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(vxy.c(1000L * l)).intValue();
      int j = Integer.valueOf(vxy.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramsph, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private spg a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label360:
    int i;
    try
    {
      localspg = new spg();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label579;
      }
      localspg.jdField_a_of_type_Boolean = bool;
      localspg.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localspg.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localspg.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localspg.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localspg.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localspg.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localspg.jdField_a_of_type_JavaUtilList == null) {
        localspg.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new spi(2);
        ((spi)localObject3).a((JSONObject)localObject2, 6);
        localspg.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new spi(4);
        ((spi)localObject3).a((JSONObject)localObject2, 10);
        localspg.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new spi(3);
        ((spi)localObject3).a((JSONObject)localObject2, 10);
        localspg.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label446;
      }
      if (localspg.jdField_b_of_type_JavaUtilList != null) {
        break label567;
      }
      localspg.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      spg localspg;
      Object localObject3;
      ved.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
      return null;
    }
    if (i < ((JSONArray)localObject2).length())
    {
      localObject3 = ((JSONArray)localObject2).getJSONObject(i);
      if (localObject3 != null)
      {
        localObject3 = a((JSONObject)localObject3, false);
        if (localObject3 != null)
        {
          localspg.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label572;
          label446:
          ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
        }
      }
    }
    else
    {
      localObject1 = ((JSONObject)localObject1).optJSONArray("mutableFestivalList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = j;
        if (localJSONException.jdField_b_of_type_JavaUtilList == null)
        {
          localJSONException.jdField_b_of_type_JavaUtilList = new ArrayList();
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject2 != null)
        {
          localObject2 = a((JSONObject)localObject2, true);
          if (localObject2 != null)
          {
            localJSONException.jdField_b_of_type_JavaUtilList.add(localObject2);
            break label585;
            ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
        }
      }
      else
      {
        return localJSONException;
        label567:
        i = 0;
        break label360;
        label572:
        i += 1;
        break label360;
        label579:
        bool = false;
        break;
      }
      label585:
      i += 1;
    }
  }
  
  private sph a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    sph localsph = new sph(i);
    localsph.a(paramJSONObject, 6);
    localsph.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localsph.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localsph.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localsph.jdField_c_of_type_Int == -2147483648) || (localsph.d == -2147483648))
    {
      ved.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localsph.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localsph.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localsph.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localsph;
      localsph.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localsph.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        ved.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localsph.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localsph.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private sqw a(@NonNull sph paramsph, Card paramCard, int paramInt)
  {
    paramsph = new sqw(paramsph, paramCard, paramInt);
    ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramsph });
    return paramsph;
  }
  
  private sqx a(@NonNull spi paramspi)
  {
    paramspi = new sqx(paramspi);
    ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramspi });
    return paramspi;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Spg != null) {
      return this.jdField_a_of_type_Spg.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Spg != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_Spg.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_Spg.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Spg != null) {
      return this.jdField_a_of_type_Spg.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<sqx> a()
  {
    if ((this.jdField_a_of_type_Spg == null) || (this.jdField_a_of_type_Spg.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Spg.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Spg.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((spi)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<sps> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Spg == null) || (this.jdField_a_of_type_Spg.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Spg.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_Spg.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (sph)((Iterator)localObject1).next();
        if ((((sph)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((sph)localObject2).jdField_c_of_type_Int)))
        {
          ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((sph)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((sph)localObject2).d)))
        {
          ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((sph)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((sph)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new spv((sqw)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            ved.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_Spg, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              sqw localsqw = (sqw)localIterator.next();
              if ((localsqw.a > 0L) && (localsqw.b > 0L)) {
                localArrayList.add(0, new spv(localsqw));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            ved.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = tcs.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Spg = a(str2);
    }
    String str3 = tcs.g();
    this.jdField_a_of_type_Int = a(str3);
    String str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    for (;;)
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_Spg });
    return this.jdField_a_of_type_Spg != null;
  }
  
  public boolean a(String paramString)
  {
    spg localspg = a(paramString);
    if (localspg != null)
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_Spg, paramString });
      tcs.h(paramString);
      this.jdField_a_of_type_Spg = localspg;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Spg != null) {
      return this.jdField_a_of_type_Spg.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Spg != null) {
      return this.jdField_a_of_type_Spg.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    tcs.h("");
    this.jdField_a_of_type_Spg = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Spg != null) {
      return this.jdField_a_of_type_Spg.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    tcs.i(paramString);
    return true;
  }
  
  public void c()
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    tcs.i("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Spg != null)
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spf
 * JD-Core Version:    0.7.0.1
 */