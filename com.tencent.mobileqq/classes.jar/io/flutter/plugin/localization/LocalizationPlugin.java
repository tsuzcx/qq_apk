package io.flutter.plugin.localization;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

public class LocalizationPlugin
{
  @NonNull
  private final Context context;
  @NonNull
  private final LocalizationChannel localizationChannel;
  
  public LocalizationPlugin(@NonNull Context paramContext, @NonNull LocalizationChannel paramLocalizationChannel)
  {
    this.context = paramContext;
    this.localizationChannel = paramLocalizationChannel;
  }
  
  public Locale resolveNativeLocale(List<Locale> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1;
      Object localObject2;
      int i;
      Object localObject3;
      Object localObject4;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = new ArrayList();
        localObject2 = this.context.getResources().getConfiguration().getLocales();
        int j = ((LocaleList)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject3 = ((LocaleList)localObject2).get(i);
          ((List)localObject1).add(new Locale.LanguageRange(((Locale)localObject3).toString().replace("_", "-")));
          ((List)localObject1).add(new Locale.LanguageRange(((Locale)localObject3).getLanguage()));
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((Locale)localObject3).getLanguage());
          ((StringBuilder)localObject4).append("-*");
          ((List)localObject1).add(new Locale.LanguageRange(((StringBuilder)localObject4).toString()));
          i += 1;
        }
        localObject1 = Locale.lookup((List)localObject1, paramList);
        if (localObject1 == null) {}
      }
      do
      {
        return localObject1;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            for (;;)
            {
              return (Locale)paramList.get(0);
              if (Build.VERSION.SDK_INT < 24) {
                break;
              }
              localObject1 = this.context.getResources().getConfiguration().getLocales();
              i = 0;
              while (i < ((LocaleList)localObject1).size())
              {
                localObject2 = ((LocaleList)localObject1).get(i);
                localObject3 = paramList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (Locale)((Iterator)localObject3).next();
                  if (((Locale)localObject2).equals(localObject4)) {
                    return localObject4;
                  }
                }
                localObject3 = paramList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (Locale)((Iterator)localObject3).next();
                  if (((Locale)localObject2).getLanguage().equals(((Locale)localObject4).toLanguageTag())) {
                    return localObject4;
                  }
                }
                localObject3 = paramList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (Locale)((Iterator)localObject3).next();
                  if (((Locale)localObject2).getLanguage().equals(((Locale)localObject4).getLanguage())) {
                    return localObject4;
                  }
                }
                i += 1;
              }
            }
            localObject1 = this.context.getResources().getConfiguration().locale;
          } while (localObject1 == null);
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Locale)((Iterator)localObject2).next();
            if (((Locale)localObject1).equals(localObject3)) {
              return localObject3;
            }
          }
          localObject2 = paramList.iterator();
        }
        localObject3 = (Locale)((Iterator)localObject2).next();
      } while (!((Locale)localObject1).getLanguage().equals(((Locale)localObject3).toString()));
      return localObject3;
    }
    return null;
  }
  
  public void sendLocalesToFlutter(@NonNull Configuration paramConfiguration)
  {
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramConfiguration = paramConfiguration.getLocales();
      int j = paramConfiguration.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramConfiguration.get(i));
        i += 1;
      }
    }
    localArrayList.add(paramConfiguration.locale);
    this.localizationChannel.sendLocales(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.localization.LocalizationPlugin
 * JD-Core Version:    0.7.0.1
 */