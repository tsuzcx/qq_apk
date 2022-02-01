package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k=4, mv={1, 1, 16})
public final class Okio
{
  @NotNull
  public static final Sink appendingSink(@NotNull File paramFile)
  {
    return Okio__JvmOkioKt.appendingSink(paramFile);
  }
  
  @JvmName(name="blackhole")
  @NotNull
  public static final Sink blackhole()
  {
    return Okio__OkioKt.blackhole();
  }
  
  @NotNull
  public static final BufferedSink buffer(@NotNull Sink paramSink)
  {
    return Okio__OkioKt.buffer(paramSink);
  }
  
  @NotNull
  public static final BufferedSource buffer(@NotNull Source paramSource)
  {
    return Okio__OkioKt.buffer(paramSource);
  }
  
  public static final boolean isAndroidGetsocknameError(@NotNull AssertionError paramAssertionError)
  {
    return Okio__JvmOkioKt.isAndroidGetsocknameError(paramAssertionError);
  }
  
  @JvmOverloads
  @NotNull
  public static final Sink sink(@NotNull File paramFile)
  {
    return sink$default(paramFile, false, 1, null);
  }
  
  @JvmOverloads
  @NotNull
  public static final Sink sink(@NotNull File paramFile, boolean paramBoolean)
  {
    return Okio__JvmOkioKt.sink(paramFile, paramBoolean);
  }
  
  @NotNull
  public static final Sink sink(@NotNull OutputStream paramOutputStream)
  {
    return Okio__JvmOkioKt.sink(paramOutputStream);
  }
  
  @NotNull
  public static final Sink sink(@NotNull Socket paramSocket)
  {
    return Okio__JvmOkioKt.sink(paramSocket);
  }
  
  @IgnoreJRERequirement
  @NotNull
  public static final Sink sink(@NotNull Path paramPath, @NotNull OpenOption... paramVarArgs)
  {
    return Okio__JvmOkioKt.sink(paramPath, paramVarArgs);
  }
  
  @NotNull
  public static final Source source(@NotNull File paramFile)
  {
    return Okio__JvmOkioKt.source(paramFile);
  }
  
  @NotNull
  public static final Source source(@NotNull InputStream paramInputStream)
  {
    return Okio__JvmOkioKt.source(paramInputStream);
  }
  
  @NotNull
  public static final Source source(@NotNull Socket paramSocket)
  {
    return Okio__JvmOkioKt.source(paramSocket);
  }
  
  @IgnoreJRERequirement
  @NotNull
  public static final Source source(@NotNull Path paramPath, @NotNull OpenOption... paramVarArgs)
  {
    return Okio__JvmOkioKt.source(paramPath, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Okio
 * JD-Core Version:    0.7.0.1
 */