package com.tencent.mobileqq.dt;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/dt/QQDtReporter$Companion;", "", "()V", "INSTANCT", "Lcom/tencent/mobileqq/dt/QQDtReporter;", "instance", "instance$annotations", "getInstance", "()Lcom/tencent/mobileqq/dt/QQDtReporter;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQDtReporter$Companion
{
  @Nullable
  public final QQDtReporter a()
  {
    if (QQDtReporter.a() == null) {
      try
      {
        if (QQDtReporter.a() == null) {
          QQDtReporter.a(new QQDtReporter(null));
        }
        Unit localUnit = Unit.INSTANCE;
      }
      finally {}
    }
    return QQDtReporter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dt.QQDtReporter.Companion
 * JD-Core Version:    0.7.0.1
 */